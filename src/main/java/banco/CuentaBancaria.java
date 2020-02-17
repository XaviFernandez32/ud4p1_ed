
package banco;

public class CuentaBancaria {

	private String titular;
	private String saldo;
	private String entidad;
	private String oficina;
	private static String digitoControl; // Implementamos este Atributo
	private String numCuenta;
	private String ccc;
	private double ingreso;
	private double retirado;
	private double saldoCuenta;

	public static final int MINIMO = 10, MAXIMO = 100;

	public CuentaBancaria(String titular, String saldo, String entidad, String oficina, String digitoControl,
			String numCuenta) throws Exception {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.entidad = entidad;
		this.oficina = oficina;
		this.numCuenta = numCuenta;
		this.digitoControl = calcularDigitoControl(entidad, oficina, numCuenta);

	}

	public CuentaBancaria(String titular, String ccc) {
		super();
		this.titular = titular;
		this.ccc = this.entidad + " " + this.oficina + " " + this.digitoControl + " " + this.numCuenta;
		this.entidad = ccc.substring(0, 4);// 4 cifras
		this.oficina = ccc.substring(5, 9);// 4 cifras
		this.digitoControl = ccc.substring(10, 12);// 2 cifras
		this.numCuenta = ccc.substring(13, ccc.length());// hasta el final
	}

	public CuentaBancaria() {

	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		if (titular.length() < MAXIMO && titular.length() > MINIMO) {
			this.titular = titular;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public static String getDigitoControl() {
		return digitoControl;
	}

	public void setDigitoControl(String digitoControl) {
		this.digitoControl = digitoControl;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getCcc() {
		this.ccc = this.entidad + " " + this.oficina + " " + this.digitoControl + " " + this.numCuenta;
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public double getIngreso() {
		return ingreso;
	}

	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}

	public double getRetirado() {
		return retirado;
	}

	public void setRetirado(double retirado) {
		this.retirado = retirado;
	}

	@Override
	public String toString() {
		return "Cuenta Bancaria:\nTitular: " + titular + "\nSaldo de la cuenta: " + saldo + "\nccc: " + getCcc();
	}

	public void ingresar(double ingreso) {
		saldoCuenta = Double.parseDouble(getSaldo());
		saldoCuenta += ingreso;
		if (ingreso > 0) {
			System.out.println("Actualmente tienes en la cuenta " + saldoCuenta);
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void retirar(double retirado) {
		saldoCuenta = Double.parseDouble(getSaldo());
		saldoCuenta -= retirado;
		if (retirado > 0) {
			System.out.println("Actualmente tienes en la cuenta " + saldoCuenta);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static String calcularDigitoControl(String entidad, String oficina, String numCuenta) {

		// calculo del primer digito
		String parte1 = "00" + entidad + oficina;
		int sumatorio = calcularDigito(parte1);

		int resto1 = sumatorio % 11;
		int digito1 = 11 - resto1;

		// calculo del segundo digito
		String parte2 = numCuenta;
		sumatorio = calcularDigito(parte2);

		int resto2 = sumatorio % 11;
		int digito2 = 11 - resto2;

		if (digito1 == 11) {
			digito1 = 0;
		} else if (digito2 == 11) {
			digito2 = 0;
		} else if (digito1 == 10) {
			digito1 = 1;
		} else if (digito2 == 10) {
			digito2 = 1;
		}

		return String.valueOf(digito1) + String.valueOf(digito2);
	}

	private static int calcularDigito(String subCadena) {
		char cadena;
		int sumatorio1 = 0;
		int multiplicador = 0;
		int num = 0;
		for (int i = 0; i < subCadena.length(); i++) {
			if (i == 0) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 1;
				sumatorio1 += num * multiplicador;

			} else if (i == 1) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 2;
				sumatorio1 += num * multiplicador;

			} else if (i == 2) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 4;
				sumatorio1 += num * multiplicador;

			} else if (i == 3) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 8;
				sumatorio1 += num * multiplicador;

			} else if (i == 4) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 5;
				sumatorio1 += num * multiplicador;

			} else if (i == 5) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 10;
				sumatorio1 += num * multiplicador;

			} else if (i == 6) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 9;
				sumatorio1 += num * multiplicador;

			} else if (i == 7) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 7;
				sumatorio1 += num * multiplicador;

			} else if (i == 8) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 3;
				sumatorio1 += num * multiplicador;

			} else if (i == 9) {
				cadena = subCadena.charAt(i);
				num = Integer.parseInt(cadena + "");
				multiplicador = 6;
				sumatorio1 += num * multiplicador;
			}

		}

		return sumatorio1;

	}

	public static boolean comprobarCCC(String ccc) {
		String entidad = ccc.substring(0, 4);// 4 cifras
		String oficina = ccc.substring(5, 9);// 4 cifras
		String digitoControl = ccc.substring(10, 12);// 2 cifras
		String numCuenta = ccc.substring(13, ccc.length());// hasta el final

		if (ccc.length() == 23 && digitoControl.equals(getDigitoControl())) {

			return true;
		} else {
			return false;
		}

	}
}
