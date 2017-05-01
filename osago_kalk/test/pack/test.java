package pack;

import static org.junit.Assert.*;

import org.junit.Test;

import kalk.klient;

public class test {

	@Test
	public void test1() {
		// Грузовой автомобиль (<16 т.)
		// От 120 до 150 л.с.
		// До 22 лет, стаж выше 3 лет
		// Без ограничения
		float k1=(float)1.4,k2=(float)1.6,k3=2025,k4=(float)1.8;
		int s;
		//s - значение из функции sums, расположенной в классе klient
		s=klient.sums(k1,k2,k3,k4);
		// tests - итоговое значение
		int tests=14697;
		// итоговая сверка
		assertEquals(tests,s);
		
	}
	
	@Test
	public void test2() {
		// Грузовой автомобиль (>=16 т.)
		// >150 л.с.
		// До 22 лет, стаж до 3 лет
		// Ограниченный список водителей
		float k1=(float)1.6,k2=(float)1.8,k3=3240,k4=1;
		int s;
		//s - значение из функции sums, расположенной в классе klient
		s=klient.sums(k1,k2,k3,k4);
		// tests - итоговое значение
		int tests=16796;
		// итоговая сверка
		assertEquals(tests,s);
		
	}
}
