package com.ngc.battledrills.servlet;

import com.ngc.battledrills.manage.TemplateManager;
import com.ngc.battledrills.vmf.VmfManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author admin
 */
public class Listener implements ServletContextListener{
    private VmfManager vmfMgr;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TemplateManager manager = TemplateManager.getInstance();
        vmfMgr = new VmfManager();
        vmfMgr.startKMessageMonitor();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        if(vmfMgr != null)
        {
            vmfMgr.stopKMessageMonitor();
        }
    }
    
}
