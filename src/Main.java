import com.antz.load.LoadCode;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-27-6:03
 */
public class Main {
    public static void main(String[] args) {
        LoadCode loadCode = new LoadCode("code.antz") ;
    }
}
/*
(
        while (i < 10)
        (
                    (
                            if ((i % 2) == 0)
                                ((even = (even + i)))
                            else
                                ((odd = (odd + i)))
                    )
                    (i = (i + 1))
        )
)
*/