package designPatterns.liskovsSubstitutionPrinciple.example1;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
      //  construct(building);
       // construct(office);

        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building());
        buildingList.add(new Building());
        printBuildings(buildingList);

        List<Office> officeList = new ArrayList<>();
        officeList.add(new Office());
        officeList.add(new Office());
        printBuildings(officeList);

        addBuildings(officeList);

    }

    public static void construct(Building building) {
        System.out.println(building.toString());
    }

    public static void printBuildings(List<? extends Building> buildings) {
        for(Building building: buildings) {
            System.out.println(building);
        }
    }

    public static void addBuildings(List<? super Office> buildings) {
        buildings.add(new Office());
    }

    /*
    // The below code will not work for any offices and we need to create redundant methods
    public static void printBuildings(List<Building> buildingList) {

        for(Building building: buildingList) {
            System.out.println(building);
        }
    }*/
}
