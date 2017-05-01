/**
 * объявление пакета
 */
package kalk;
/**
 * Импорт библиотек классов, необходимых для работы.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Объявление публичного класса, наследующего члены класса JFrame, для создания окна клиента, где рассчитывается стоимиость полиса 
 */

public class klient extends JFrame {
	/**
	 * Создаются переменные k1,k2,k3,k4,k5, которые используется при расчете стоимости ОСАГО, 
	 * k1 - мощность двигателя, k2 - возраст и стаж владельца,k3 - тип транспортного средства,
	 * k4 - допущенные к управлению водители
	 * Переменная s используется для получения стоимости ОСАГО.
	 */
	float k1,k2,k3,k4;
	int s;
	/**
	 * Метод, отвечающий за запуск фрейма
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					klient frame = new klient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		
	/**
	 * Объявление метода, в котором объявляются элементы экранной формы, ее события, а также проводятся вычисления полиса ОСАГО
	 */
	public klient() {
		/**
		 * Задаем необходимые параметры при оформлении полиса ОСАГА в переменные item, item1, item2, item3.
		 */
		String[] items = {
				"<=50 л.с",
			    "От 50 до 70 л.с.",
			    "От 70 до 100 л.с.",
			    "От 100 до 120 л.с.",
			    "От 120 до 150 л.с.",
			    ">150 л.с."
			};
		
		String[] items1 = {
			    "До 22 лет, стаж до 3 лет",
			    "До 22 лет, стаж свыше 3 лет",
			    "Свыше 22 лет, стаж до 3 лет",
			    "Свыше 22 лет, стаж свыше 3 лет"
			};
		String[] items2 = {
			    "Легковой автомобиль",
			    "Мотоцикл",
			    "Грузовой автомобиль (>=16 т.)",
			    "Грузовой автомобиль (<16 т.)",
			    "Автобус (число мест >=20)",
			    "Автобус (число мест <20)"
			};
		String[] items3 = {
			    "Ограниченный список водителей",
			    "Без ограничения"
			};
		/**
		 * Создание главной панели
		 */
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Клиент"));
		/**
		 * Создание панелей для: 
		 * выпадающих списков и меток
		 * кнопки
		 */
		JPanel Panel1 = new JPanel(new GridLayout(8, 1));
		Panel1.setBounds(10,15,280,200);
		JPanel Panel2 = new JPanel();
		Panel2.setLayout(null);
		Panel2.setBounds(300,15,350,200);
		/**
		 * Задание шрифта и размера надписей для кнопок, меток, переключателей
		 */
		Font font = new Font("Verdana", Font.PLAIN, 14);
		
		/**
		 * Создание меток 
		 */
		JLabel label_1 = new JLabel("Мощность двигателя");
		label_1.setFont(font);
		JLabel label_2 = new JLabel("Возвраст и стаж владельца");
		label_2.setFont(font);
		JLabel label_3 = new JLabel("Тип транспортного средства");
		label_3.setFont(font);
		JLabel label_4 = new JLabel("Лица, допущенные к управлению");
		label_4.setFont(font);
		JLabel label_5 = new JLabel("0 руб.");
		label_5.setBounds(80, 120, 350, 20);
		label_5.setFont(font);
		/**
		 * Создание выпадающих списков
		 */
		JComboBox comboBox = new JComboBox(items);
		comboBox.setFont(font);
		JComboBox comboBox_1 = new JComboBox(items1);
		comboBox_1.setFont(font);
		JComboBox comboBox_2 = new JComboBox(items2);
		comboBox_2.setFont(font);
		JComboBox comboBox_3 = new JComboBox(items3);
		comboBox_3.setFont(font);
		
		/**
		 * Создание кнопки
		 */
		JButton btnNewButton = new JButton("Рассчитать");
		btnNewButton.setFont(font);
		btnNewButton.setBounds(50, 80, 140, 40);
		
		/**
		 * Добавление элементов на панель для выпадающих списков
		 */
		Panel1.add(label_1);
		Panel1.add(comboBox);
		Panel1.add(label_2);
		Panel1.add(comboBox_1);
		Panel1.add(label_3);
		Panel1.add(comboBox_2);
		Panel1.add(label_4);
		Panel1.add(comboBox_3);
		/**
		 * Добавление элементов на панель для кнопки
		 */
		Panel2.add(btnNewButton);
		Panel2.add(label_5);
		/**
		 * Добавление элементов на главную панель
		 */
		contentPane.add(Panel1);
		contentPane.add(Panel2);
		/**
		 * Указание размера, расположения, названия экранной формы, добавление на нее главной панели
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Калькулятор ОСАГО");
		setContentPane(contentPane);
		setBounds(100, 100, 570, 280);
		/**
		 * Событие для кнопки "Рассчитать". Вычисление стоимости полиса ОСАГО
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Данный оператор, в зависимости от выбранной мощности двигателя, устанавливае коэффициент k1.
				 */
				switch (comboBox.getSelectedIndex())
				{
				case 0: k1=(float)(0.6);
				break;
				
				case 1: k1=(float)(1);
				break;
				
				case 2: k1=(float)(1.1);
				break;
				
				case 3: k1=(float)(1.2);
				break;
				
				case 4: k1=(float)(1.4);
				break;
				
				case 5: k1=(float)(1.6);
				break;
				}
				/**
				 * Данный оператор, в зависимости от выбранного стажа и возраста водителя, устанавливае коэффициент k2.
				 */
				switch (comboBox_1.getSelectedIndex())
				{
				case 0: k2=(float)(1.8);
				break;
				
				case 1: k2=(float)(1.6);
				break;
				
				case 2: k2=(float)(1.7);
				break;
				
				case 3: k2=(float)(1);
				break;
				}
				/**
				 * Данный оператор, в зависимости от выбранного типа транспортного средства, устанавливае коэффициент k3.
				 */
				switch (comboBox_2.getSelectedIndex())
				{
				case 0: k3=(float)(1980);
				break;
				
				case 1: k3=(float)(1215);
				break;
				
				case 2: k3=(float)(3240);
				break;
				
				case 3: k3=(float)(2025);
				break;
				
				case 5: k3=(float)(1620);
				break;
				
				case 4: k3=(float)(2025);
				break;
				}
				/**
				 * Данный оператор, в зависимости от выбранного количества допущенных к управлению водителей, устанавливае коэффициент k4.
				 */
				if (comboBox_3.getSelectedIndex()== 0) k4=1;
				else k4=(float)(1.8);
				/**
				 * Вычисляет стоимость ОСАГО
				 */
				s=sums(k1,k2,k3,k4);
				/**
				 * Выводит полученную стоимость в метку "0 руб."
				 */
				label_5.setText(Integer.toString(s) + " руб.");
			}
		});
	}
	
	public static int sums(float k1,float k2,float k3,float k4)
	{
	float sum;
	int s;
	sum = k1*k2*k3*k4*(float)(1.8);
	s = Math.round(sum);
	return s;
	}
}
