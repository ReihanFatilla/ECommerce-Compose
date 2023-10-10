# E-Commerce Compose

This Android application is Mock List and Detail E-Commerce App built with Jetpack Compose, Clean Architecture, buildSrc and Koin.

<table>
  <tr>
    <td><img src="https://github.com/ReihanFatilla/ECommerce-Compose/assets/88997868/fdd4eb14-176c-471e-bc72-5bce8f1ed7b8" alt="Screenshot 1"></td>
    <td><img src="https://github.com/ReihanFatilla/ECommerce-Compose/assets/88997868/9380550d-61bc-40b2-a8ca-7d1091e0953d" alt="Screenshot 2"></td>
    <td><img src="https://github.com/ReihanFatilla/ECommerce-Compose/assets/88997868/71569529-7bf6-4e31-b14f-dea29cd6d1d8" alt="Screenshot 3"></td>
    <td><img src="https://github.com/ReihanFatilla/ECommerce-Compose/assets/88997868/9e923d9f-7de9-4f19-ac84-b30f50b6d533" alt="Screenshot 4"></td>
  </tr>
</table>


## Features

1. **Product List Pagination Page:**
   - Displays a paginated list of items fetched from a public API.

2. **Detail Page:**
   - Users can view detailed information about a selected product.

3. **Add To Cart:**
   - Allows users to add products to their shopping cart, which is stored locally using Room database.

4. **My Cart Page:**
   - Users can view the products they have added to their cart.

5. **Search Page:**
   - Implements product search functionality to help users find products quickly.

## Technical Details

- **Programming Language:** Kotlin
- **Architecture:** Clean Architecture with MVVM
- **Dependency Injection:** Koin
- **Local Database:** Room
- **Reactive Programming:** Kotlin Coroutine Flow
- **Dependency Management:** BuildSrc and Version Catalog

## Additional Value

- **Jetpack Compose:** Utilized Jetpack Compose for building the user interface, making it more dynamic and user-friendly.
- **Modular Codebase:** Organized the codebase into separate modules: `core` (Domain + Data Layer) and `app` (Presentation Layer) for better code organization and maintainability.
- **Notification:** Implemented Work Manager to send notifications of the last opened product to users every 15 minutes.

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository.

3. Open the project in Android Studio.

4. Build and run the app on an Android emulator or physical device.

## Feedback and Contributions

We welcome feedback and contributions to improve this project. If you have any suggestions or find any issues, please open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

Feel free to add more details, installation instructions, or any other information specific to your project as needed. This README serves as a starting point for your project's documentation on GitHub.

