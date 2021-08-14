# RestAssured-ServeRest-Tests

☕ Automated API tests for [ServeRest](https://serverest.dev) using Java/Rest Assured.

<details>
  <summary>🛠 Technologies Used</summary>

- Java
- Gradle
- Rest Assured
- jUnit
- Hamcrest

</details>

---

## 📄 Test Cases

| Test Case ID | Test Case Name                                                                       | Endpoint | Manual Execution (Postman) | Automation |
| ------------ | ------------------------------------------------------------------------------------ | -------- | -------------------------- | ---------- |
| 1            | Should return status code 200, message and token when email and password are correct | /login   | ✔                          | ✔          |
| 2            | Should return status code 401 and message when email is incorrect                    | /login   | ✔                          | ✔          |
| 3            | Should return status code 401 and message when password is incorrect                 | /login   | ✔                          | ✔          |
