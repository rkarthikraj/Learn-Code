package leetcode.msiq;

import java.util.*;

/*
ls not working
 */

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

class FileSystem {
    private class FileNode {
        public Map<String, FileNode> children;
        public boolean isFile;
        public String fileContent;

        public FileNode(boolean isFile) {
            this.isFile = false;
            this.children = new HashMap<>();
            this.fileContent = "";
        }
    }

    private FileNode root;
    public FileSystem() {
        root = new FileNode(false);
    }

    public List<String> ls(String path) {
        List<String> fileAndDirs = new LinkedList<>();

        String[] subDirs = path.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subDirs.length; ++i) {
            String subDir = subDirs[i];
            fileNode = fileNode.children.get(subDir);
        }

        if(fileNode.isFile){
            fileAndDirs.add(subDirs[subDirs.length - 1]);
            return fileAndDirs;
        }

        for(String child : fileNode.children.keySet()) {
            fileAndDirs.add(child);
        }

        Collections.sort(fileAndDirs);

        return fileAndDirs;
    }

    public void mkdir(String path) {
        String[] subDirs = path.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subDirs.length; ++i) {
            String subDir = subDirs[i];
            if (fileNode.children.containsKey(subDir)) {
                fileNode = fileNode.children.get(subDir);
                continue;
            }

            FileNode newNode = new FileNode(false);
            fileNode.children.put(subDir, newNode);
            fileNode = newNode;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] subDirs = filePath.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subDirs.length; ++i) {
            String subDir = subDirs[i];
            if (fileNode.children.containsKey(subDir)) {
                fileNode = fileNode.children.get(subDir);
                continue;
            }

            FileNode newNode = new FileNode(i == subDirs.length - 1);
            fileNode.children.put(subDir, newNode);
            fileNode = newNode;
        }
        fileNode.fileContent += content;
    }

    public String readContentFromFile(String filePath) {
        String[] subDirs = filePath.split("/");
        FileNode fileNode = root;
        for (int i = 1; i < subDirs.length; ++i) {
            String subDir = subDirs[i];
            fileNode = fileNode.children.get(subDir);
        }
        return fileNode.fileContent;
    }

    public static void main(String[] args) {
        FileSystem obj = null;
        //String[] operations = {"FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"};
        //String[][] values = {{}, {"/"}, {"/a/b/c"}, {"/a/b/c/d", "hello"}, {"/"}, {"/a/b/c/d"}};

        String[] operations = {"FileSystem", "mkdir", "ls", "ls", "mkdir", "ls", "ls", "addContentToFile", "ls", "ls", "ls"};
        String[][] values = {{}, {"/goowmfn"}, {"/goowmfn"}, {"/"}, {"/z"}, {"/"}, {"/"}, {"/goowmfn/c", "shetopcy"}, {"/z"}, {"/goowmfn/c"}, {"/goowmfn"}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];
            switch (operation) {
                case "FileSystem":
                    obj = new FileSystem();
                    break;
                case "ls":
                    System.out.println(obj.ls(values[i][0]));
                    //obj.ls(values[i][0]);
                    break;
                case "mkdir":
                    obj.mkdir(values[i][0]);
                    break;
                case "addContentToFile":
                    obj.addContentToFile(values[i][0], values[i][1]);
                    break;
                case "readContentFromFile":
                    System.out.println(obj.readContentFromFile(values[i][0]));
                    //obj.readContentFromFile(values[i][0]);
                    break;
            }
        }
    }
}

