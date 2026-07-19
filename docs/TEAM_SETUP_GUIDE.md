# 🚀 Team Setup Guide

Welcome to the **Log Stream** project.

Please follow the steps below carefully before starting development.

---

# 📌 Step 1: Accept the GitHub Invitation

1. Open the invitation email sent by GitHub.
2. Click **Accept Invitation**.
3. Open the repository in your GitHub account.
4. Verify that you have access to the repository.

---

# 📌 Step 2: Clone the Repository

> **⚠️ Do NOT download the ZIP file.**

### Clone using Git

1. Open the repository on GitHub.
2. Click the green **Code** button.
3. Copy the **HTTPS** repository URL.
4. Open **Git Bash**, **PowerShell**, or **Terminal**.
5. Navigate to the location where you want to save the project.

Example:

```bash
cd Desktop
```

or

```bash
cd Documents
```

Clone the repository:

```bash
git clone <repository-url>
```

Go inside the project folder:

```bash
cd log-stream
```

---

# 📌 Step 3: Open the Project

1. Open **IntelliJ IDEA**.
2. Click **Open**.
3. Select the **log-stream** folder.
4. Wait until IntelliJ finishes indexing the project.

---

# 📌 Step 4: Get All Remote Branches

Open the IntelliJ terminal and execute:

```bash
git fetch origin
```

Check available branches:

```bash
git branch -a
```

Expected output:

```text
main
remotes/origin/main
remotes/origin/develop
```

---

# 📌 Step 5: Switch to the Develop Branch

Run:

```bash
git checkout develop
```

If the branch does not exist locally, execute:

```bash
git checkout -b develop origin/develop
```

Verify your current branch:

```bash
git branch
```

Expected output:

```text
* develop
  main
```

---

# 📌 Step 6: Create Your Own Feature Branch

> **⚠️ Never work directly on `main` or `develop`.**

Create your own branch:

```bash
git checkout -b feature/<your-name>-<module>
```

Example:

```text
feature/john-backend
feature/jane-grpc
feature-alex-frontend
```

Push your branch to GitHub:

```bash
git push -u origin feature/<your-name>-<module>
```

> **Note:** This command is required **only once** when creating your branch.

---

# 📌 Step 7: Start Working

✅ Work only on your assigned module.

✅ Work only inside your own feature branch.

❌ Never switch to `main` or `develop` while developing.

---

# 📌 Step 8: Before Starting Work Every Day

Always update your local project before writing new code.

### Switch to the develop branch

```bash
git checkout develop
```

### Pull the latest changes

```bash
git pull origin develop
```

### Switch back to your feature branch

```bash
git checkout feature/<your-name>-<module>
```

### Merge the latest develop branch

```bash
git merge develop
```

Now begin your work.

---

# 📌 Step 9: Commit Your Changes

Check modified files:

```bash
git status
```

Stage your changes:

```bash
git add .
```

Commit your work:

```bash
git commit -m "feat: short description of your work"
```

### ✅ Good Commit Messages

```text
feat: implement log entity
feat: add grpc server
fix: resolve validation issue
docs: update README
```

### ❌ Avoid

```text
update
done
changes
final
```

Push your changes:

```bash
git push
```

---

# 📌 Step 10: Create a Pull Request

1. Open the repository on GitHub.
2. Click **Compare & Pull Request**.
3. Verify the following:

**Source Branch**

```text
feature/<your-name>-<module>
```

**Target Branch**

```text
develop
```

4. Click **Create Pull Request**.

> **⚠️ Never create a Pull Request directly to `main`.**

---

# 📌 Step 11: Code Review

Wait for your Pull Request to be reviewed.

If changes are requested:

- Make the required changes.
- Commit the changes.
- Push again.

Once approved, merge the Pull Request into **develop**.

---

# 📋 Team Rules

## ✅ Always

- Create your own feature branch.
- Pull the latest changes before starting work.
- Push your work regularly.
- Write meaningful commit messages.
- Create a Pull Request for every completed task.
- Use the existing Spring Boot project from the repository.
- Discuss any structural changes with the team before making them.

## ❌ Never

- Commit directly to `main`.
- Work directly on `develop`.
- Create another Spring Boot project.
- Rename project folders or package structures without team approval.
- Use meaningless commit messages.

---

# 📅 Daily Progress Update

At the end of each working day, share your progress in the team group using the format below:

```text
✅ Completed
- Task 1
- Task 2

🚀 Working On
- Task 3

🚧 Blocked By
- Any issue or dependency
```

---

# 🔄 Git Workflow

```text
Accept GitHub Invitation
          │
          ▼
Clone Repository
          │
          ▼
Open Project
          │
          ▼
Switch to develop
          │
          ▼
Create Feature Branch
          │
          ▼
Write Code
          │
          ▼
Commit Changes
          │
          ▼
Push Branch
          │
          ▼
Create Pull Request
          │
          ▼
Code Review
          │
          ▼
Merge into develop
          │
          ▼
After Testing → Merge develop into main
```

---

## 📞 Need Help?

If you encounter any issue while setting up the project or working on your assigned module, inform the team immediately instead of trying random fixes. It is better to ask early than to create merge conflicts or lose work.