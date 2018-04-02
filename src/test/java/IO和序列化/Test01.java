package IO和序列化;

import Model.LvKang;
import org.junit.Test;

import java.io.*;

/**
 * @author: kangkang.lv
 * @date: 17-11-2 下午4:07
 */
public class Test01 {
    private static String filePath = "/home/lvkang/resume/fileTest.txt";

    //序列化
    @Test
    public void t01_1() throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/lvkang/resume/fileTest2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        LvKang lvk = new LvKang(26,190,75);
        oos.writeObject(lvk);
        oos.close();
        fos.close();
    }

    //反序列化
    @Test
    public void t01_2() throws Exception {
        FileInputStream fis = new FileInputStream("/home/lvkang/resume/fileTest2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        LvKang lvk = (LvKang) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(lvk.toString());

    }

    //文件流
    /**
     * File提供了支持字符读写的封装类：FileWriter和FileReader
     * 所以不必每次都使用InputStreamReader和OutputStreamWriter来转换。
     */
    @Test
    public void t10() throws Exception{
        FileReader fr = new FileReader(filePath);
        // FileReader直接read方法没有readLine方便，所以套上装饰类BufferedReader借它的readLine用一用
        BufferedReader br = new BufferedReader(fr);
        String str;
        while ((str = br.readLine())!=null){
            System.out.printf(str);
        }
        br.close();
        fr.close();
    }
    @Test
    public void t09() throws Exception{
        FileWriter fw = new FileWriter(filePath);
        fw.write("这是测试09");
        fw.close();
    }

    /**
     * InputStreamReader,字节到字符的转化桥梁，转化过程中需指定编码字符集，否则采用默认字符集(UTF-8)。
     *
     * @throws Exception
     */
    @Test
    public void t08() throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str;
        while ((str = br.readLine())!=null){
            System.out.printf(str);
        }
        br.close();
        isr.close();
        fis.close();

    }
    /**
     *
     * OutputStreamWriter,字节到字符的转化桥梁，转化过程中需指定编码字符集，否则采用默认字符集。
     *
     * @throws Exception
     */
    @Test
    public void t07() throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/lvkang/resume/fileTest.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("这是测试07...");
        bw.flush();
        osw.close();
        fos.close();
    }

    @Test
    public void t06() throws Exception {
        FileInputStream fis = new FileInputStream("/home/lvkang/resume/fileTest.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buffer = new byte[100];
        int len;
        while ((len = bis.read(buffer))>-1){
            String str = new String(buffer,0,len);
            System.out.printf(str);
        }
        bis.close();
        fis.close();

    }

    /**
     *
     * 缓冲区处理流：BufferedInputStream，BufferedOutputStream，BufferedReader,BufferedWriter,
     * 一次性写入，降低占用IO的频率
     * 避免每次和硬盘打交道，提高数据访问的效率。
     *
     * @throws Exception
     */
    @Test
    public void t05() throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/lvkang/resume/fileTest.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);   //装饰器模式
        bos.write("测试05".getBytes());
        bos.flush();    // 每次flush会将内存中数据一齐刷入到外部文件中，但不会close该流。
        bos.write(" 0505".getBytes());
        /**
         * close方法除了有关闭流的作用，在其关闭流之前也会执行一次flush。
         * 注意一定要先关闭BufferedOutputStream，再关闭FileOutputStream，从外到内打开，要从内到外关闭。
         */
        bos.close();
        fos.close();
    }

    /**
     * 使用输入流读取InputStream.read，将设备文件（这里的磁盘文件是File）读到内存buffer中去。
     * @throws Exception
     */
    @Test
    public void t04() throws Exception {
        FileInputStream fi = new FileInputStream("/home/lvkang/resume/fileTest.txt");
        byte[] buffer = new byte[200];
        int len;
        while ((len = fi.read(buffer))>-1){
            String str = new String(buffer,0,len);
            System.out.print(str);
        }
        fi.close();
    }

    /**
     * 使用输出流OutputStream.write，将内存中的内容写入设备文件（这里的设备文件为File：磁盘文件）
     * @throws Exception
     */
    @Test
    public void t03() throws Exception {
        FileOutputStream fo = new FileOutputStream("/home/lvkang/resume/fileTest.txt");
        String str = "这是文件内容";
        fo.write(str.getBytes());
        fo.close();

        FileOutputStream fo1 = new FileOutputStream("/home/lvkang/resume/fileTest.txt",true);
        fo1.write(" !".getBytes());
        fo1.close();
    }

    //File
    @Test
    public void t02() throws IOException {
        File file = new File("/home/lvkang/resume/fileTest.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        File fileDir = new File("/home/lvkang/resume");
        if (fileDir.exists()){
            String[] list = fileDir.list();
            for (String l : list){
                System.out.println(l);
            }
        }
        System.out.println("----");
        System.out.println("fileDir.length: "+fileDir.length());
        System.out.println("fileDir.getName: "+fileDir.getName());
        System.out.println("fileDir.getParent: "+fileDir.getParent());
    }

    //序列化
    @Test
    public void t01() throws Exception {
        LvKang lvk = new LvKang(26,190,75);
        /* 序列化 */
        //定义一个字节数组输入流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        //将对象写入到字节数组输出,进行序列化
        oos.writeObject(lvk);
        byte[] lvkBytes = baos.toByteArray();
        System.out.println(lvkBytes);


        /* 反序列化 */
        //字节数组输入流
        ByteArrayInputStream bais = new ByteArrayInputStream(lvkBytes);
        //执行反序列化,从流中读取对象
        ObjectInputStream ois = new ObjectInputStream(bais);
        LvKang lvKang = (LvKang) ois.readObject();
        System.out.println(lvKang.toString());
    }

}
