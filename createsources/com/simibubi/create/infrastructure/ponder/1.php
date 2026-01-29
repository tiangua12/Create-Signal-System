<?php
// 默认使用DeepSeek建议的25MB限制，可根据需要调整
define('DEFAULT_MAX_SIZE', 25 * 1024 * 1024);

// 参数处理
$directory = isset($argv[1]) ? $argv[1] : '.';
$outputFile = isset($argv[2]) ? $argv[2] : 'bundle.java';
$maxSize = isset($argv[3]) ? parse_size($argv[3]) : DEFAULT_MAX_SIZE;

function parse_size($size) {
    $unit = strtoupper(substr($size, -1));
    $value = substr($size, 0, -1);
    switch ($unit) {
        case 'K': return $value * 1024;
        case 'M': return $value * 1024 * 1024;
        case 'G': return $value * 1024 * 1024 * 1024;
        default:  return (int)$size;
    }
}

// 验证目录有效性
$directoryRealPath = realpath($directory);
if ($directoryRealPath === false) die("无效目录: $directory\n");

// 递归遍历目录
$iterator = new RecursiveIteratorIterator(
    new RecursiveDirectoryIterator($directory, FilesystemIterator::SKIP_DOTS),
    RecursiveIteratorIterator::SELF_FIRST
);

$outputContent = '';
$totalSize = 0;

foreach ($iterator as $fileInfo) {
    if (!$fileInfo->isFile() || 'java' !== strtolower($fileInfo->getExtension())) continue;

    // 计算相对路径
    $filePath = $fileInfo->getRealPath();
    $relativePath = ltrim(str_replace($directoryRealPath, '', $filePath), DIRECTORY_SEPARATOR);
    $relativePath = str_replace(DIRECTORY_SEPARATOR, '/', $relativePath);

    // 构建文件头
    $header = "//文件$relativePath\n";
    $content = @file_get_contents($filePath);
    if ($content === false) continue;

    // 计算大小
    $sectionSize = strlen($header) + strlen($content);
    if ($totalSize + $sectionSize > $maxSize) break;

    // 追加内容
    $outputContent .= $header . $content;
    $totalSize += $sectionSize;
}

// 生成输出文件
file_put_contents($outputFile, $outputContent);
echo "生成文件: $outputFile\n总大小: " . round($totalSize/1024/1024, 2) . "MB\n";
?>