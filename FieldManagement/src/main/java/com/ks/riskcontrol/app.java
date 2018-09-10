package com.ks.riskcontrol;

import com.ks.riskcontrol.git.JGitUtil;
import com.ks.riskcontrol.services.InsertField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class app {
    private static final Logger log=LogManager.getLogger(app.class);
    private static JGitUtil jGitUtil;
    private static InsertField insertField;
    static {
        jGitUtil=new JGitUtil();
        jGitUtil.cloneRepository();
        insertField=new InsertField();
    }
    public void taskExcution() throws IOException {
        log.trace("========================拉取数据========================");
        try {
            jGitUtil.pull();
        } catch (Exception e) {
            log.error("git pull error");
            throw new IllegalAccessError("git pull error");
        }
        try {
            insertField.perform();
        }
        catch (Exception e){
            log.error("insert field error");
            throw new IllegalAccessError("insert field error");
        }
        log.info("data import is successful ！");
    }
}
