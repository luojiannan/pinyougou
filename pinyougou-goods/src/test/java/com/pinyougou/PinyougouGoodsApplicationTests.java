package com.pinyougou;

import com.pinyougou.goods.redis.GoodsRedis;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PinyougouGoodsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	GoodsRedis goodsRedis;

	@Test
	public void tes2() {
		goodsRedis.add();
	}

	@Test
	public void test1(){
		System.out.println(goodsRedis.get());
	}

	@Test
	public void test3(){
		goodsRedis.delete();
	}

	@Test
	public void fileInput() {
		FileInputStream in = null;
		try {
			in = new FileInputStream("E:\\git命令.txt");
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定的文件");
			e.printStackTrace();
		}
		int num = 0;
		int b = 0;
		try {
			while((b = in.read()) != -1) {
				System.out.print((char)b);
				num++;
			}
			in.close();
			System.out.println("读取了" +num +"个字节");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInputAndOutput() {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:\\资料.txt");
			out = new FileOutputStream("E:\\字节流测试.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int b = 0;
		try {
			while((b=in.read()) != -1) {
				out.write(b);
            }
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFileReader() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("E:\\git命令.txt");
			fw = new FileWriter("E:\\字节流测试.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int b = 0;
		try {
			while ((b=fr.read()) != -1) {
				System.out.print((char)b);
				fw.write(b);
			}
			fr.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void buffered() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:\\流.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\字节流测试.txt"));
			for (int i = 0;i<=100;i++) {
				String s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			int b = 0;
			String s = null;
			while ((s = br.readLine()) != null) {
				bw.write(s);
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void outputStream() {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\字节流测试.txt"));
			osw.write("bbbbbbb");
			System.out.println(osw.getEncoding());
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("ssss");
            bw.close();
            osw = new OutputStreamWriter(new FileOutputStream("E:\\字节流测试.txt",true),"ISO8859-1");
            osw.write("asdfsafsafd");
            System.out.println(osw.getEncoding());
            osw.close();

        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @Test
    public void testsss() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            String s = br.readLine();
            while(StringUtils.isNotBlank(s)) {
                System.out.println(s);
                s = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
