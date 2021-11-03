package puntoFlotante;

import calculatorConverter.CalculartorConverter;

import java.util.Arrays;

public class Medium {

    CalculartorConverter calculatorConverter = new CalculartorConverter();

    private Byte[] valor = new Byte[3];


    public Medium (){
        this.valor = new Byte[] {0,0,0};
    }

    public Medium (String valorDecimal){
        String binario = "";
        if((valorDecimal.charAt(0))=='-'){
            binario = ObtenerComplementoA2(valorDecimal);

        }else{
            binario = convertirABinario(valorDecimal);
        }
        
        this.valor[0] = Byte.parseByte(binario.substring(0,8));
        this.valor[1] = Byte.parseByte(binario.substring(8,16));
        this.valor[2] = Byte.parseByte(binario.substring(16));
        //this.valor[0] = ;

        System.out.println(Arrays.toString(this.valor));
    }

    public Medium (String valorHexadecimal, String tipo){

    }

    private String convertirABinario (String decimal){
        String binario = "";
        int tamanoBinario = 0;
        System.out.println(decimal);
        //convierte decimal a base dos
        binario = calculatorConverter.convierteDeBaseDiez(decimal,2,0);

        tamanoBinario = binario.length();
        String agregarBits = "";

        for(int i = 0; i<(24-tamanoBinario);i++){
            agregarBits += "0";
        }

        binario = agregarBits + binario;

        System.out.println(binario+" tamaño binario");
        return binario;
    }

    private String ObtenerComplementoA2 (String decimal) {
        String complemento2 = "";
        decimal = decimal.substring(1);
        String binario = convertirABinario(decimal);
        int posicionPrimer1 = 0;

        for(int i = 23; i>=0 ;i--){
            if(binario.charAt(i) == '1'){
                posicionPrimer1 = i;
                break;
            }
        }

        for(int i = 0;i<binario.length();i++){
            if(i<posicionPrimer1){
                if(binario.charAt(i) == '1'){
                    complemento2 += "0";
                }else
                    complemento2 += "1";
            }else{
                complemento2 += binario.charAt(i);
            }
        }
        return complemento2;
    }



    public Byte[] getValor() {
        return valor;
    }

    public void setValor(Byte[] valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Medium{" +
                "valor=" + Arrays.toString(valor) +
                '}';
    }
}
