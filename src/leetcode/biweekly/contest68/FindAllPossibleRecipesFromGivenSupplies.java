package leetcode.biweekly.contest68;

import java.util.*;

class FindAllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
        FindAllPossibleRecipesFromGivenSupplies obj = new FindAllPossibleRecipesFromGivenSupplies();

        //        String[] recipes = {"bread", "sandwich"};
        //
        //        List<String> lst1 = new ArrayList<>(Arrays.asList("yeast", "flour"));
        //        List<String> lst2 = new ArrayList<>(Arrays.asList("bread", "meat"));
        //        List<List<String>> ingredients = new ArrayList<>(Arrays.asList(lst1, lst2));
        //
        //        String[] supplies = {"yeast", "flour", "meat"};

        String[] recipes = {"bread", "sandwich", "burger"};

        List<String> lst1 = new ArrayList<>(Arrays.asList("yeast", "flour"));
        List<String> lst2 = new ArrayList<>(Arrays.asList("bread", "meat"));
        List<String> lst3 = new ArrayList<>(Arrays.asList("sandwich", "meat", "bread"));

        List<List<String>> ingredients = new ArrayList<>(Arrays.asList(lst1, lst2, lst3));

        String[] supplies = {"yeast", "flour", "meat"};

        System.out.println(obj.findAllRecipes(recipes, ingredients, supplies));
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();

        Set<String> supply = new HashSet<>();
        for (int s = 0; s < supplies.length; s++) {
            if (!supply.contains(supplies[s])) {
                supply.add(supplies[s]);
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int r = 0; r < recipes.length; r++) {
                // System.out.println(recipes[r] + " - " + ingredients.get(r));
                Boolean isAvailableInSupply = true;
                for (int j = 0; j < ingredients.get(r).size(); j++) {
                    if (!supply.contains(ingredients.get(r).get(j))) {
                        isAvailableInSupply = false;
                    }
                }

                if (isAvailableInSupply) {
                    if(!result.contains(recipes[r])) {
                        result.add(recipes[r]);
                    }
                    if (!supply.contains(recipes[r])) {
                        supply.add(recipes[r]);
                    }
                }
            }
        }
        return result;
    }
}