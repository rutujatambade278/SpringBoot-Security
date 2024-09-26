package com.springboot3security.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springboot3security.Entity.UserInfo;
import com.springboot3security.Repository.UserInfoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class ReportService {

    @Autowired
    private UserInfoRepository repository;

    
    public byte[] generateReport() throws FileNotFoundException, JRException {
        List<UserInfo> users = repository.findAll();

        JasperReport report = loadTemplate();
        JasperPrint print = fillReport(report, users);

        return exportReport(print);
    }

    private JasperReport loadTemplate() throws JRException, FileNotFoundException {
        File templateFile = ResourceUtils.getFile("classpath:/templates/Login.jasper");
        return JasperCompileManager.compileReport(templateFile.getAbsolutePath());
    }

    private JasperPrint fillReport(JasperReport report, List<UserInfo> users) throws JRException {
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(users));
    }

    private byte[] exportReport(JasperPrint print) throws JRException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(print, out);
        return out.toByteArray();
    }
}
