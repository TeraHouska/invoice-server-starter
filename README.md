# Účetnictví - evidence faktur (backend)
> Projekt byl vytvořen za pomoci kurzů ITnetwork.

Celý projekt zahrnuje dvouserverovou webovou aplikaci na evidenci faktur a osob. Backend je vytvořen v Javě ve frameworku SpringBoot a využívá framework Hibernate pro mapování s databází. Frontend je dále implementován v projektu [invoice-client-starter](https://github.com/TeraHouska/invoice-client-starter) v JS knihovně React.

V tomto projektu naleznete backendovou část aplikace zahrnující server v Javě ve Spring, který komunikuje s klientem pomocí REST API.

## Technologie
- **Java**
  - Spring
  - JPA (Hibernate)
  - Lombok
  - Mapstruct
- **MySQL**
  - phpMyAdmin

## Funkcionality
Aplikace umí veškeré CRUD operace s fakturami a s osobami, umí filtrovat faktury a vypsat souhrnné statistiky osob a faktur.

- **Osoby**
  - Přidání nové osoby
  - Detail osoby
  - Úprava osoby
  - Smazání osoby
  - Výpis seznamu osob
- **Faktury**
  - Přidání nové faktury
  - Detail faktury
  - Úprava faktury
  - Smazání faktury
  - Výpis seznamu faktur
    - Filtrace faktur
- **Statistiky**
  - Souhrn faktur
  - Souhrn faktur podle osoby
    

## Ukázky výstupů API
### Detail osoby
![detail osoby](https://github.com/user-attachments/assets/de7ef779-5835-4ebb-806d-5cc9bea84722)
### Přidání nové faktury
![přidání nové faktury](https://github.com/user-attachments/assets/2972c63b-0381-4c37-9536-b775513029af)
### Výpis statistik
![statistiky](https://github.com/user-attachments/assets/e6f0e0b9-6ff2-42b3-bdd3-0f3eaacde60a)

