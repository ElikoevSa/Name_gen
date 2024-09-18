package NameGenerator;

import NameGenerator.data.Affix;
import NameGenerator.data.Suffix;
import NameGenerator.data.repositoryImpl.DataRepositoryIMPL;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataRepositoryIMPL dataRepositoryIMPL =new DataRepositoryIMPL();
//        System.out.println("введите имя сущности :");
//        Scanner scanner = new Scanner(System.in);
        Affix id = new Affix();
//        id.setAffixName(scanner.nextLine());
//        Prefix res = new Prefix(scanner.nextLine());
//        dataRepositoryIMPL.save(id);
        List <Object> list1 = dataRepositoryIMPL.findAll(id.getClass());
        list1.forEach(System.out::println);
            List<Object> list =new ArrayList<>();
            list.add(new Suffix("TestSuffix1"));
             list.add(new Suffix("TestSuffix"));
//        list.add(new Suffix("TestSuffix3"));
//        list.add(new Suffix("TestSuffix4"));
//        list.add(new Affix("TestAffix11"));
//        list.add(new Affix("TestAffix22"));
//        dataRepositoryIMPL.saveAll(list);
    }
}