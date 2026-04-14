# Recettes Pizza
> **LAB 6 - Application "Recettes de Pizza" 🍕**
---
Ce TP a pour but de développer une application Android en Java qui affiche une liste de pizzas avec leur nom, prix, durée de préparation et image, puis d’accéder à un détail complet de chaque recette.

L’objectif est de comprendre :
L’organisation d’un projet Android en packages logiques (classes, dao, service, adapter, ui),
La manipulation d’une ListView avec Adapter personnalisé,
Le passage de données entre activités,
L’utilisation d’un Splash Screen animé,
Et la mise en œuvre d’un modèle de données orienté objet.

## 🎬Vidéo de démonstration

Vous pouvez visualiser le test de l'application ici :
---


## 🛠️ Technical Stack

- **Language**: Java
- **Architecture**: DAO Pattern with Singleton Service.
- **UI Components**:
  - `ListView` for the pizza collection.
  - `ConstraintLayout` & `ScrollView` for responsive detail pages.
  - `BaseAdapter` for custom list rendering.
- **Resources**: Custom `mipmap` icons and images.

## 📂 Project Structure

- `com.example.pizzarecipes.classes`: Contains the `Produit` model.
- `com.example.pizzarecipes.dao`: Data Access Object interface.
- `com.example.pizzarecipes.service`: `ProduitService` managing the pizza data (Singleton).
- `com.example.pizzarecipes.adapter`: Custom `PizzaAdapter` for the list.
- `com.example.pizzarecipes.ui`: Contains `SplashActivity`, `ListPizzaActivity`, and `PizzaDetailActivity`.

## 🚀 How to Run

1. Clone the repository.
2. Open the project in **Android Studio**.
3. Sync Gradle and build the project.
4. Run the app on an emulator or a physical Android device.

## Auteure
Developed by NAFTAOUI NIAMA
