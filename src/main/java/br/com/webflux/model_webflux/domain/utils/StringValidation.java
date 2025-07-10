package br.com.webflux.model_webflux.domain.utils;


import java.util.regex.Pattern;

public class StringValidation {
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
  private static final Pattern CEP_PATTERN = Pattern.compile("^\\d{5}-\\d{3}$");

  public static boolean isValidCep(String cep) {
    return cep != null && CEP_PATTERN.matcher(cep).matches();
  }

  public static boolean isValidEmail(String email) {
    return email != null && EMAIL_PATTERN.matcher(email).matches();
  }

  public static boolean isValidCpf(String cpf) {
    if (cpf == null) return false;
    cpf = cpf.replaceAll("\\D", "");

    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
      return false;
    }

    try {
      int d1 = 0, d2 = 0;
      for (int i = 0; i < 9; i++) {
        int digito = Character.getNumericValue(cpf.charAt(i));
        d1 += digito * (10 - i);
        d2 += digito * (11 - i);
      }

      d1 = (d1 * 10) % 11;
      d1 = (d1 == 10) ? 0 : d1;

      d2 += d1 * 2;
      d2 = (d2 * 10) % 11;
      d2 = (d2 == 10) ? 0 : d2;

      return d1 == Character.getNumericValue(cpf.charAt(9)) &&
          d2 == Character.getNumericValue(cpf.charAt(10));
    } catch (Exception e) {
      return false;
    }
  }
}
