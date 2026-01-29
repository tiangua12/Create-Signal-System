<?php

function checkFilesForMultipleStrings($directory, $searchStrings) {
    // 检查是否是有效的目录
    if (!is_dir($directory)) {
        return "错误：'$directory' 不是一个有效的目录";
    }

    // 获取当前脚本的文件名，用于跳过自身
    $currentScript = basename(__FILE__);
    $results = [];
    $totalFiles = 0;

    // 初始化结果数组
    $results['files'] = [];

    // 获取目录中的所有文件和子目录
    $iterator = new RecursiveDirectoryIterator($directory);
    $totalFilesIterator = new RecursiveIteratorIterator($iterator);
    foreach ($totalFilesIterator as $file) {
        if ($file->isFile() && $file->getFilename() !== $currentScript && strpos($file->getFilename(), '.') !== 0) {
            $totalFiles++;
        }
    }

    // 重置迭代器用于实际检查
    $iterator = new RecursiveDirectoryIterator($directory);
    $fileCount = 0;
    foreach (new RecursiveIteratorIterator($iterator) as $file) {
        // 跳过目录本身，只处理文件
        if ($file->isDir()) {
            continue;
        }

        // 跳过当前脚本自身
        if ($file->getFilename() === $currentScript) {
            continue;
        }

        // 跳过隐藏文件
        if (strpos($file->getFilename(), '.') === 0) {
            continue;
        }

        $fileCount++;
        // 输出正在检查的文件和剩余文件数量
        echo "正在检查文件 $fileCount/$totalFiles: " . $file->getPathname() . "\n";

        // 检查文件是否可读
        if (!is_readable($file->getPathname())) {
            echo "无法读取文件: " . $file->getPathname() . "\n";
            continue;
        }

        // 读取文件内容
        $content = file_get_contents($file->getPathname());

        // 检查文件内容是否包含所有目标字符串
        $foundAll = true;
        foreach ($searchStrings as $string) {
            if (strpos($content, $string) === false) {
                $foundAll = false;
                break;
            }
        }

        if ($foundAll) {
            $results['files'][] = $file->getPathname();
        }
    }

    return $results;
}

// 执行检查
$directory = __DIR__; // 当前目录
$searchStrings = [ "fuck"]; // 要同时检查的字符串列表
$results = checkFilesForMultipleStrings($directory, $searchStrings);

// 输出结果
if (count($results['files']) > 0) {
    echo "\n以下文件同时包含所有指定的字符串：\n";
    foreach ($results['files'] as $file) {
        echo "- " . $file . "\n";
    }
} else {
    echo "\n没有找到同时包含所有指定字符串的文件。\n";
}

?>
