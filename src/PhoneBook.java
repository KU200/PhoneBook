import java.util.ArrayList;
import java.util.*;//инициализируем сканер
import java.util.Collections;

public class PhoneBook {

    public static void main(String args[]) {

        Scanner in;
        in = new Scanner(System.in);

        ArrayList<Phone> phoneNum = new ArrayList<Phone>();

        int b = 1; //создаем бесконечный цикл
        MainMenu:
        //при этом делаем метку MainMenu: для возврата в эту часть
        for (int i = 1; i <= 2; i++) {
            i = b;

            System.out.println("\nДля создания контакта нажмите 1\n"
                    + "Для изменения или удаления контакта нажмите 2\n"
                    + "Для отображения списка контактов нажмите 3\n"
                    + "Для выхода из программы нажмите другой символ");

            String select = in.nextLine();//создаем переменную которая будет получать значение ввода

            if (select.equals("1")) { //если переменная значения ввода равна "1"

                System.out.println("Введите имя абонента");
                String nname = in.nextLine(); //создаем переменную которая будет получать значение ввода

                System.out.println("Введите номер абонента");
                String nnumber = in.nextLine(); //создаем переменную которая будет получать значение ввода

                Phone Num = new Phone(); //создаем экземпляр класса Phone
                Num.setNumber(nnumber); //помещаем в этот экземпляр значение номера, а далее имени введенных ранее с клавиатуры
                Num.setName(nname);
                phoneNum.add(Num); //помещаем переменные данного экземпляра в массив обьектов

            } else if (select.equals("2")) //если переменная значения ввода равна "2"
                finding:for (; ; ) { //создаем метку для возврата в меню ввода номера и создаем цикл for без условый чтобы прикрепить эту метку
                    int size = phoneNum.size();//создаем переменную равную количеству контактов книги
                    if (size < 1) {//Если в книге нет контактов
                        System.out.println("В книге нет контактов");
                        break;//возвращаемся в главное меню
                    }
                    System.out.println("Введите Имя или Номер контакта который хотите изменить или удалить\n"
                            + "Для выхода в главное меню нажмите 0");
                    select = in.nextLine(); //создаем переменную которая будет хранить значения пользовательского ввода
                    if (select.equals("0")) break;
                    for (Phone p : phoneNum) { //перебираем все контакты книги
                        if (select.equals(p.getName()) || select.equals(p.getNumber())) { //если ввод равен имени ИЛИ номеру контакта из книги...
                            System.out.println(p.getName() + "    " + p.getNumber()); //...выводим даный контакт для наглядности
                            System.out.println("Для изменения имени нажмите 1\n"
                                    + "Для изменения номера нажмите 2\n"
                                    + "Для удаления контакта нажмите 3\n"
                                    + "Для возврата в главное меню нажмите другой символ");

                            String select2 = in.nextLine();//так надо иначе будем переходить в главное меню

                            if (select2.equals("1")) {
                                System.out.println("Введите новое имя");
                                p.setName(in.nextLine());//задаем новое имя даному контакту
                            } else if (select2.equals("2")) {
                                System.out.println("Введите новый номер");
                                p.setNumber(in.nextLine());//задаем новый номер даному контакту
                            } else if (select2.equals("3")) {
                                if (size < 2) {
                                    System.out.println("Это был последный контакт, книга пуста");
                                    phoneNum.clear();//если в массиве 1 обьект то удалять можно только так
                                    break;//Выходим в главное меню если книга пуста
                                } else {
                                    int idx = phoneNum.indexOf(p);//узнаем индекс даного обьекта в массиве
                                    phoneNum.remove(idx);//удаляем его по индексу
                                }

                            } else if (!select.equals(p.getName()) || !select.equals(p.getNumber())) {//если не нашло контакт по номеру и имени
                                System.out.println("Такого контакта не существует попробуйте еще раз");
                                continue finding;//переходим к метке ввода имени и номера искомого контакта
                            }
                        }
                    }
                }
            else if (select.equals("3")) { // если в главном меню ввели "3"

                System.out.println("Список контактов:");
                phoneNum.forEach(System.out::println);//вывод всех контактов книги
                System.out.println("Для сортировкм списка нажмите 1\n"
                        + "Для выхода в главное меню нажмите другой символ");

                select = in.nextLine();//так надо иначе будем переходить в главное меню

                if (select.equals("1")) {

                    Collections.sort(phoneNum, new PhoneComparator());//сортируем все контакты книги
                    System.out.println("Отсортированый список контактов: ");
                    for (Phone p : phoneNum) {
                        System.out.println(p);
                    }
                } else
                    continue MainMenu; //при нажатии клавиши отменной от "1" возвращаемся к метке MainMenu в главное меню
            } else break;
        }
    }
}



