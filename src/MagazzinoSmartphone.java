import java.util.ArrayList;

public class MagazzinoSmartphone {
    private ArrayList <Smartphone> smartphones;
    private int count;

    // Costruttore Default
    public MagazzinoSmartphone() {
        smartphones = new ArrayList <Smartphone>(10); // Assuming initial capacity of 10
        count = 0;
    }

    // Costruttore Master
    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        smartphones = new ArrayList <Smartphone>(10);
        for (int i = 0; i < smartphones.size(); i++) {
            if (other.smartphones.get(i) != null) {
                smartphones.set(i, new Smartphone(other.smartphones.get(i)));
                count++;
            }
        }
    }

    // Metodo aggiungi Smartphone
    public void addSmartphone(Smartphone smartphone) {
        smartphones.add(smartphone);
        count++;
        
    }

    // Metodo rimuovi Smartphone
    public void removeSmartphone(Smartphone smartphone) {
        // smartphones = new Smartphone[10];
        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i) != null) {
                if (smartphones.get(i).equals(smartphone)) {
                    smartphones.set(i, null);
                    count--;
                }
            }
        }
    }

    // Metodo che restituisce l'array di Smartphone
    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[count];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, count);
        return smartphoneArray;
    }

    // Metodo che ricerca uno Smartphone per Brand
    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        int i = 0;
        boolean r = false;
        while (r == false && i <= smartphones.size()) {
            if (smartphones.get(i) != null) {
                if (smartphones.get(i).getBrand().equals(brand)) {
                    smartphone = smartphones.get(i);
                    r = true;
                }
            }
            i++;
        }
        return smartphone;
    }

    // Metodo che restituisce uno Smartphone per capacità di memoria
    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        int i = 0;
        boolean r = false;
        while (r == false && i <= smartphones.size()) {
            if (smartphones.get(i) != null) {
                if (smartphones.get(i).getStorageCapacity() == storageCapacity) {
                    magazzinoSmartphone.addSmartphone(smartphones.get(i));
                    r = true;
                }
            }
            i++;
        }
        return magazzinoSmartphone;
    }

    // Metodo che restituisce uno Smartphone per range di prezzo
    public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i) != null) {
                if (smartphones.get(i).getPrice() > minPrice && smartphones.get(i).getPrice() < maxPrice) {
                    magazzinoSmartphone.addSmartphone(smartphones.get(i));
                }
            }
        }
        return magazzinoSmartphone;
    }

    // Metodo tostring
    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n";
        for (int i = 0; i < smartphones.size(); i++) {
            if (smartphones.get(i) != null) {
                result += "Brand: " + smartphones.get(i).getBrand()+  ", Model: " + smartphones.get(i).getModel()
                          + ", Storage Capacity: " + smartphones.get(i).getStorageCapacity() +"GB, Price: "
                          + smartphones.get(i).getPrice() + "\n";
            }
        }
        return result;
    }

    // Metodo che restituisce il contatore degli Smartphone presenti nel'array
    public int getCount() {
        return count;
    }

    // Metodo equals
    public boolean equals(Object obj) {
        boolean r = false;
        if (this == obj) {
            r = true;
        } else if (obj instanceof MagazzinoSmartphone) {
            MagazzinoSmartphone magazzinoSmartphone = (MagazzinoSmartphone) obj;
            for (int i = 0; i < smartphones.size(); i++) {
                if (smartphones.get(i) != null) {
                    if (this.smartphones.get(i).getBrand().equals(magazzinoSmartphone.smartphones.get(i).getBrand())
                    && this.smartphones.get(i).getModel().equals(magazzinoSmartphone.smartphones.get(i).getModel())
                    && this.smartphones.get(i).getStorageCapacity() == magazzinoSmartphone.smartphones.get(i).getStorageCapacity()
                    && this.smartphones.get(i).getPrice() == magazzinoSmartphone.smartphones.get(i).getPrice()) {
                        r = true;
                }
                }
            }
        }
        return r;
    }

}