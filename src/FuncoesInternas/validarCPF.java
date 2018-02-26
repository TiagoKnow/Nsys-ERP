
package FuncoesInternas;

import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class validarCPF {


    public boolean validarCPF(String cpf){
        try{
            boolean resultado = false;

            long var_a, var_b, var_c, var_d, var_e, var_f, var_g, var_h, var_i, var_j, var_k = 0;
            long dig1, dig2 = 0;
            long aux1, aux2, aux3, aux4 = 0;

            var_a = Long.parseLong(cpf.substring(0, 1));
            var_b = Long.parseLong(cpf.substring(1, 2));
            var_c = Long.parseLong(cpf.substring(2, 3));
            var_d = Long.parseLong(cpf.substring(3, 4));
            var_e = Long.parseLong(cpf.substring(4, 5));
            var_f = Long.parseLong(cpf.substring(5, 6));
            var_g = Long.parseLong(cpf.substring(6, 7));
            var_h = Long.parseLong(cpf.substring(7, 8));
            var_i = Long.parseLong(cpf.substring(8, 9));

            dig1 = Long.parseLong(cpf.substring(9, 10));
            dig2 = Long.parseLong(cpf.substring(10, 11));

            aux1 = (var_a * 10) + (var_b * 9) + (var_c * 8) + (var_d * 7) + (var_e * 6) + (var_f * 5) + (var_g * 4) + (var_h * 3) + (var_i * 2);
            aux2 = aux1 % 11;

            if ((aux2 == 0) || (aux2 == 1)){
                var_j = 0;
            }else{
                var_j = 11 - aux2;
            }

            aux3 = (var_a * 11) + (var_b * 10) + (var_c * 9) + (var_d * 8) + (var_e * 7) + (var_f * 6) + (var_g * 5) + (var_h * 4) + (var_i * 3) + (var_j * 2);
            aux4 = aux3 % 11;

            if ((aux4 == 0) || (aux4 == 1)){
                var_k = 0;
            }else{
                var_k = 11 - aux4;
            }

            if((dig1 == var_j) && (dig2 == var_k)){
                resultado = true;
            }else{
                resultado = false;
            }

            return resultado;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "O erro foi ao validar CPF" + e);
            return false;
        }
    }
}
