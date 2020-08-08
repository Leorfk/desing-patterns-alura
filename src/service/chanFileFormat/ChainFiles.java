package service.chanFileFormat;

import domain.Conta;
import domain.Requisicao;
import service.interfaces.Response;

public class ChainFiles {
    public void generateFile(Requisicao request, Conta conta){
        Response response1 = new FileCSV();
        Response response2 = new FileXML();
        Response response3 = new FilePORCENTO();

        response1.nextResponseFormat(response2);
        response2.nextResponseFormat(response3);
        response3.nextResponseFormat(null);

        response1.responde(request, conta);
    }
}
