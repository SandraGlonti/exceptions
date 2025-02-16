package pl.kurs.preTestHomework.contacts.model;

public enum Category {
    PRACA, RODZINA, ZNAJOMI, INNE;

    public static Category fromString(String category)throws IllegalArgumentException{
        try{
            return Category.valueOf(category.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Niepoprawna kategoria. Wybierz z: PRACA, RODZINA, ZNAJOMI, INNE");
        }
    }
}
