package br.edu.fafica.buscaguiaapp;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Eric Gustavo on 03/12/2016.
 */

public class Webservice {
    private static String URL = "http://192.168.1.123:9090/BuscaGuia/services/Webservice?wsdl";
    private static String NOMESPACE = "http://webservice.buscaguia.com";

    public Webservice(){

    }

    public Guia guiaProcurarNome(String nome) throws Exception{
        Guia guia = new Guia();
        SoapObject soap = new SoapObject(NOMESPACE, "guiaProcurarNome");
        soap.addProperty("nome", nome);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        envelope.implicitTypes = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.call("urm:guiaProcurarNome", envelope);

        SoapObject resultado = (SoapObject) envelope.getResponse();

        int id_guia = Integer.parseInt(resultado.getProperty("id_guia").toString());
        String nome1 = resultado.getProperty("nome").toString();
        String cpf = resultado.getProperty("cpf").toString();
        String imagem = resultado.getProperty("imagem").toString();
        String descricao = resultado.getProperty("descricao").toString();
        String logradouro = resultado.getProperty("logradouro").toString();
        String numero = resultado.getProperty("numero").toString();
        String bairro = resultado.getProperty("bairro").toString();
        String email = resultado.getProperty("bairro").toString();
        String tel = resultado.getProperty("telefone").toString();
        String cel = resultado.getProperty("celular").toString();
        int id_adm = Integer.parseInt(resultado.getProperty("id_adm").toString());

        guia.setId_guia(id_guia);
        guia.setNome(nome1);
        guia.setCpf(cpf);
        guia.setImagem(imagem);
        guia.setDescricao(descricao);
        guia.setLogradouro(logradouro);
        guia.setNumero(numero);
        guia.setBairro(bairro);
        guia.setEmail(email);
        guia.setTelefone(tel);
        guia.setCelular(cel);
        guia.setId_adm(id_adm);

        return guia;
    }

    public Guia guiaProcurarId(int id) throws Exception{
        Guia guia = new Guia();
        SoapObject soap = new SoapObject(NOMESPACE, "guiaProcurarId");
        soap.addProperty("id", id);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        envelope.implicitTypes = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.call("urm:guiaProcurarId", envelope);

        SoapObject resultado = (SoapObject) envelope.getResponse();

        int id_guia = Integer.parseInt(resultado.getProperty("id_guia").toString());
        String nome1 = resultado.getProperty("nome").toString();
        String cpf = resultado.getProperty("cpf").toString();
        String imagem = resultado.getProperty("imagem").toString();
        String descricao = resultado.getProperty("descricao").toString();
        String logradouro = resultado.getProperty("logradouro").toString();
        String numero = resultado.getProperty("numero").toString();
        String bairro = resultado.getProperty("bairro").toString();
        String email = resultado.getProperty("bairro").toString();
        String tel = resultado.getProperty("telefone").toString();
        String cel = resultado.getProperty("celular").toString();
        int id_adm = Integer.parseInt(resultado.getProperty("id_adm").toString());

        guia.setId_guia(id_guia);
        guia.setNome(nome1);
        guia.setCpf(cpf);
        guia.setImagem(imagem);
        guia.setDescricao(descricao);
        guia.setLogradouro(logradouro);
        guia.setNumero(numero);
        guia.setBairro(bairro);
        guia.setEmail(email);
        guia.setTelefone(tel);
        guia.setCelular(cel);
        guia.setId_adm(id_adm);

        return guia;
    }

    public ArrayList<Guia> guiaListar() throws Exception{
        ArrayList<Guia> lista = new ArrayList<Guia>();

        SoapObject soap = new SoapObject(NOMESPACE,"guiaListar");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        envelope.implicitTypes = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.call("urm:guiaListar", envelope);

        Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

        for(SoapObject soapObject: resposta){
            int id_guia = Integer.parseInt(soapObject.getProperty("id_guia").toString());
            String nome1 = soapObject.getProperty("nome").toString();
            String cpf = soapObject.getProperty("cpf").toString();
            String imagem = soapObject.getProperty("imagem").toString();
            String descricao = soapObject.getProperty("descricao").toString();
            String logradouro = soapObject.getProperty("logradouro").toString();
            String numero = soapObject.getProperty("numero").toString();
            String bairro = soapObject.getProperty("bairro").toString();
            String email = soapObject.getProperty("bairro").toString();
            String tel = soapObject.getProperty("telefone").toString();
            String cel = soapObject.getProperty("celular").toString();
            int id_adm = Integer.parseInt(soapObject.getProperty("id_adm").toString());

            Guia guia = new Guia();

            guia.setId_guia(id_guia);
            guia.setNome(nome1);
            guia.setCpf(cpf);
            guia.setImagem(imagem);
            guia.setDescricao(descricao);
            guia.setLogradouro(logradouro);
            guia.setNumero(numero);
            guia.setBairro(bairro);
            guia.setEmail(email);
            guia.setTelefone(tel);
            guia.setCelular(cel);
            guia.setId_adm(id_adm);

            lista.add(guia);

        }

        return lista;
    }

    public ArrayList<Guia> guiaListarNome(String nome) throws Exception{
        ArrayList<Guia> lista = new ArrayList<Guia>();

        SoapObject soap = new SoapObject(NOMESPACE,"guiaListarNome");
        soap.addProperty("nome", nome);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);
        envelope.implicitTypes = true;

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.call("urm:guiaListarNome", envelope);

        Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

        for(SoapObject soapObject: resposta){
            int id_guia = Integer.parseInt(soapObject.getProperty("id_guia").toString());
            String nome1 = soapObject.getProperty("nome").toString();
            String cpf = soapObject.getProperty("cpf").toString();
            String imagem = soapObject.getProperty("imagem").toString();
            String descricao = soapObject.getProperty("descricao").toString();
            String logradouro = soapObject.getProperty("logradouro").toString();
            String numero = soapObject.getProperty("numero").toString();
            String bairro = soapObject.getProperty("bairro").toString();
            String email = soapObject.getProperty("bairro").toString();
            String tel = soapObject.getProperty("telefone").toString();
            String cel = soapObject.getProperty("celular").toString();
            int id_adm = Integer.parseInt(soapObject.getProperty("id_adm").toString());

            Guia guia = new Guia();

            guia.setId_guia(id_guia);
            guia.setNome(nome1);
            guia.setCpf(cpf);
            guia.setImagem(imagem);
            guia.setDescricao(descricao);
            guia.setLogradouro(logradouro);
            guia.setNumero(numero);
            guia.setBairro(bairro);
            guia.setEmail(email);
            guia.setTelefone(tel);
            guia.setCelular(cel);
            guia.setId_adm(id_adm);

            lista.add(guia);

        }

        return lista;
    }
}
