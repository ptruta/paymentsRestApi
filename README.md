Pentru a crea un request body care să includă o listă și o 
sumă într-un Java REST Controller, puteți urma următorii pași:

Definiți o clasă pentru obiectul care conține lista și suma. 
De exemplu, puteți crea o clasă numită ListaSuma:
arduino

```
public class ListaSuma {
   private List<String> lista;
   private int suma;

    // constructor, getteri și setteri
}
```
În metoda controller-ului, specificați @RequestBody pentru a indica că parametrul reprezintă un obiect trimis în corpul cererii HTTP:

```
@PostMapping("/lista-suma")
public void adaugaListaSiSuma(@RequestBody ListaSuma listaSuma) {
// logica controller-ului
}
```
În cadrul corpului cererii HTTP, specificați lista și suma ca proprietăți ale obiectului JSON:

```
{
"lista": ["element1", "element2", "element3"],
"suma": 10
}
```

Puteți testa acest endpoint folosind un client HTTP, precum Postman sau curl.




