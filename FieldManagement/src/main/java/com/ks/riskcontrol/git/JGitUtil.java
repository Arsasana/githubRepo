package com.ks.riskcontrol.git;
import java.io.File;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
public class JGitUtil {
    private static String localPath = "/usr/ksRepo";
//    private static String url = "https://github.com/liaowuqiangua/githubRepo.git";
    private static String url = "10.243.140.239:/home/git/project.git";
    private static final Logger log= LogManager.getLogger(JGitUtil.class);
    public static String cloneRepository()
    {
        try{
            log.trace("========================开始下载========================");
            File file=new File(localPath);
            delDir(file);
            CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setDirectory(new File(localPath)).call();
            log.trace("========================下载完成========================");
            return "success";
        }catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }
    public static void pull() throws IOException, GitAPIException {
        log.trace("========================拉取数据========================");
        Git git = new Git(new FileRepository(localPath+"/.git"));
        git.pull().setRemoteBranchName("master").call();
    }
    public static void delDir(File f) {
        if(f.isDirectory()) {
            File[] subFiles = f.listFiles();
            for (File subFile : subFiles) {
                delDir(subFile);
            }
        }
        f.delete();
    }
//    public static void main(String[] args) throws IOException, GitAPIException {
//        pull(localPath);
//        cloneRepository(url,localPath);
//    }
}
