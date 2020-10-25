package YiHuoJiaJieMI;

import java.util.Scanner;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Xor{
	public static void main (String[] args) throws IOException {
		Scanner choose=new Scanner(System.in);
		System.out.println("请选择你需要进行的操作：\n");
		System.out.println("1.字符串加密\n2.字符串解密\n3.图像加密\n4.图像解密\n");
		int cho = choose.nextInt();
		Scanner scan=new Scanner(System.in);
		Scanner secret=new Scanner(System.in);
		if (cho == 1) {
			System.out.println("输入需加密的字符串：");
			String password1=scan.nextLine();
			char [] array1=password1.toCharArray();	
			System.out.println("输入加密时用的密钥：");
			int sec1=secret.nextInt();
			int i;
			for(i=0;i<array1.length;i++){
				array1[i]=(char)(array1[i]^sec1);	
			}
			System.out.println("字符串加密后的结果为：");
			System.out.println(new String(array1));
			System.out.println("加密成功");
			}
		else if(cho==2){
			System.out.println("输入需解密的字符串：");
			String password2=scan.nextLine();
			char [] array2=password2.toCharArray();
			System.out.println("输入解密时用的密钥：");
			int sec2=secret.nextInt();
			int j;
			for(j=0;j<array2.length;j++){
				array2[j]=(char)(array2[j]^sec2);	
			}
			System.out.println("字符串加密后的结果为：");
			System.out.println(new String(array2));
			scan.close();
			secret.close();
			System.out.println("解密成功");
		}
		else if(cho==3){
			lockImage( "D:\\密码学\\密码学图片加解密测试用图.PNG","D:\\密码学\\bengtiao1.PNG");
			System.out.println("加密成功");
		}
		else if(cho==4){
			lockImage( "D:\\密码学\\bengtiao1.PNG","D:\\密码学\\bengtiao2.PNG");
			System.out.println("解密成功");
		}
        else{
		System.out.println("输入错误!\n");}
		choose.close();
		scan.close();
		secret.close();
	}
	private static void lockImage(String srcPath,String destPath) {
		FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream(new File(srcPath));
            fos = new FileOutputStream(new File(destPath));
			byte[] buffer = new byte[20];
			Scanner secret=new Scanner(System.in);
			System.out.println("输入解密时用的密钥：");
			int sec=secret.nextInt();
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ sec);
                }
                /*
                注意这里不能用这种循环：
                for(byte b:buffer){
                    b=b^5;
                }
                因为这种只是把字节数组的值赋予一个字节变量，最终改变的只是这个变量，
                没有真正地改变数组的元素
                 */
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
					e.printStackTrace();	
				}
			}
		}	
		secret.close();	
	}
}                                     	