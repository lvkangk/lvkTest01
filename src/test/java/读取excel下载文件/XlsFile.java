package 读取excel下载文件;

import com.lvk.util.Command;
import com.lvk.util.PumpService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: kangkang.lv
 * @date: 17-3-15 下午3:02
 */
public class XlsFile {
    public static String getContent(File f) throws Exception {
        //构建Workbook对象, 只读Workbook对象
        //直接从本地文件创建Workbook
        //从输入流创建Workbook

        FileInputStream fis = new FileInputStream(f);
        StringBuilder sb = new StringBuilder();
        jxl.Workbook rwb = Workbook.getWorkbook(fis);
//一旦创建了Workbook，我们就可以通过它来访问
//Excel Sheet的数组集合(术语：工作表)，
//也可以调用getsheet方法获取指定的工资表
        int count = 0;
        Sheet[] sheet = rwb.getSheets();
        //String fileName = "";
        //String[] fileUrl = new String[6];
        PumpService pumpService = PumpService.getInstance();
        for (int i = 0; i < sheet.length; i++) {
            Sheet rs = rwb.getSheet(i);
            for (int j = 1; j < rs.getRows(); j++) {
                final Cell[] cells = rs.getRow(j);
                pumpService.pump(new Command() {
                    @Override
                    public void execute() {
                        String[] fileUrl = cells[4].getContents().split(",");
                        if (fileUrl[0].length()>0){
                            String fileName = cells[1].getContents()+"-"+cells[3].getContents()+"-"+cells[2].getContents();
                            //System.out.println("fileName: "+fileName+" ,fileUrl: "+fileUrl.length);
                            for (int k = 0;k<fileUrl.length;k++){
                                String fName = fileName+"-("+(k+1)+")";
                                System.out.println("fName: "+fName+" ,fileUrl: "+fileUrl[k]);
                                downloadFile(fileUrl[k],"/home/lvkang/resume/QS3/"+fName);
                                //count++;
                            }
                        }
                    }
                });




                //System.out.println(count);//export001.xls(754)   export002.xls(1103)



            }

        }
        fis.close();
        return sb.toString();
    }

    public static void main(String[] args) {

        File f = new File("/home/lvkang/resume/export003.xls");
        try {
            getContent(f);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        //downloadFile("http://8.f1.dajieimg.com/n/file/T1XSEvB7VT1R4oIErK_c.pdf","D:/jianli/aaa.pdf");
    }
    public static void downloadFile(String remoteFilePath, String localFilePath)
    {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try
        {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
            {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        }
        catch (Exception e)
        {
            System.out.println("error---> remoteFilePath: "+remoteFilePath+" ,localFilePath: "+localFilePath);
            e.printStackTrace();
        }
    }
}
