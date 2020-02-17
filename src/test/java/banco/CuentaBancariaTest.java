package banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	// test ingreso 1 con int
	/*
	@Test
	void testIngresar1() {

		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");
			cuenta.ingresar(2300);

			assertEquals("3300.0", cuenta.getSaldo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	// test ingreso 2 con double
	/*
	@Test
	void testIngresar2() {
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

			cuenta.ingresar(20.1);
			assertEquals("1020.1", cuenta.getSaldo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	// test ingreso 3 con char
	/*
	@Test
	void testIngresar3() throws Exception {
		final CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

		assertThrows(Exception.class, () -> {
			cuenta.ingresar('c');
		});

	}
	*/
	@Test
	void testIngresar4() {
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

			assertThrows(IllegalArgumentException.class, () -> {
				cuenta.ingresar(-100);

			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// test retirar 1 con int
	/*
	@Test
	void testRetirar1() {

		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

			cuenta.retirar(100);
			assertEquals("900.0", cuenta.getSaldo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// test retirar 2 con double

	@Test
	void testRetirar2() {
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");
			cuenta.retirar(100.10);
			assertEquals("899.90", cuenta.getSaldo());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// test retirar 3 con char
	@Test
	void testRetirar3() throws Exception {
		CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

		assertThrows(Exception.class, () -> {
			cuenta.retirar('x');
		});
	}
	*/
	// test retirar 4 con numero negativo
	@Test
	void testRetirar4() {
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

			assertThrows(IllegalArgumentException.class, () -> {
				cuenta.retirar(-200);

			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	// test ingresayretirar1 con int
	@Test
	void testIngresaYRetira1() {

		try {

			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");

			cuenta.ingresar(300);
			assertEquals("1300.0", cuenta.getSaldo());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1300", "1234", "0189", "", "2223336661");

			cuenta.retirar(1000);
			assertEquals("300.0", cuenta.getSaldo());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// test ingresayretirar2 con double
	@Test
	void testIngresaYRetira2() {

		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1000", "1234", "0189", "", "2223336661");
			cuenta.ingresar(300.50);
			assertEquals("1300.50", cuenta.getSaldo());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1300.50", "1234", "0189", "", "2223336661");
			cuenta.retirar(1000.10);
			assertEquals("300.40", cuenta.getSaldo());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	*/
	@Test
	void testComparaCCC() {
		try {
			CuentaBancaria cuenta = new CuentaBancaria("Jose", "1300.50", "1234", "0189", "", "2223336661");
			String dc = cuenta.calcularDigitoControl("1234", "0189", "2223336661");
			assertEquals("1234" + " " + "0189" + " " + dc + " " + "2223336661", cuenta.getCcc());
			;

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
