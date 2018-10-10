package try_with_resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author licunzhi
 * @desc 改进try with resource
 * @date 2018-10-10
 */
public class ResourceUseWay {
    public static void main(String[] args) throws IOException {

        System.out.println(readData("test"));
    }

    static String readData(String message) throws IOException {
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        /*
        * 在java7中就可以使用  但是在try范围需要重新赋值进行使用
        *
        * 改进之后的java9中可以直接使用 并不需要重新
        * */
        /*try (BufferedReader br1 = br) {
            return br1.readLine();
        }*/
        try (br) {
            return br.readLine();
        }
    }
}


