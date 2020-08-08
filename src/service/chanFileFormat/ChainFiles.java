package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import service.interfaces.Response;

public class ChainFiles {
    public void generateFile(Requisicao request, Conta conta){
        Response response1 = new FileCSV();
        Response response2 = new FileXML();
        Response response3 = new FilePORCENTO();
        Response response4 = new FileNoFormat();

        response1.nextResponseFormat(response2);
        response2.nextResponseFormat(response3);
        response4.nextResponseFormat(response4);

        response1.responde(request, conta);
    }
}
