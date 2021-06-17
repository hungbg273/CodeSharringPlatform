package platform;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Component
public class Snipets {
    List<Code> codeList = new LinkedList<>();

    Snipets() {
        Code code = new Code();
        code.setCode("public static void main(String[] args) {\n" +
                "\tSpringApplication.run(CodeSharingPlatform.class,args);\n" +
                "}");
        code.setDate(LocalDateTime.now());
        codeList.add(code);
    }
    public int getLength() { return codeList.size(); };
    public Code getCodeById(int id) { return codeList.get(id);}
    void addCode(Code code) {
        codeList.add(code);
    }

    Code getCode() {
        return codeList.get(codeList.size() - 1);
    }
}
