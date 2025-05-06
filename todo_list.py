# To-Do List Manager
tasks = []

def add_task(description, priority):
    task = {"description": description, "priority": priority, "completed": False}
    tasks.append(task)
    print(f"Task '{description}' added with priority {priority}.")

def view_tasks():
    if not tasks:
        print("No tasks available.")
        return
    print("\nTo-Do List:")
    for i, task in enumerate(tasks, 1):
        status = "Completed" if task["completed"] else "Pending"
        print(f"{i}. {task['description']} (Priority: {task['priority']}, Status: {status})")

def complete_task(index):
    if 1 <= index <= len(tasks):
        tasks[index - 1]["completed"] = True
        print(f"Task '{tasks[index - 1]['description']}' marked as completed.")
    else:
        print("Invalid task index.")

def remove_task(index):
    if 1 <= index <= len(tasks):
        removed_task = tasks.pop(index - 1)
        print(f"Task '{removed_task['description']}' removed.")
    else:
        print("Invalid task index.")

def main():
    while True:
        print("\nTo-Do List Manager")
        print("1. Add Task")
        print("2. View Tasks")
        print("3. Mark Task as Completed")
        print("4. Remove Task")
        print("5. Exit")
        choice = input("Enter your choice (1-5): ")
        
        if choice == "1":
            description = input("Enter task description: ")
            try:
                priority = int(input("Enter priority (1-5): "))
                if 1 <= priority <= 5:
                    add_task(description, priority)
                else:
                    print("Priority must be between 1 and 5.")
            except ValueError:
                print("Priority must be a number.")
        elif choice == "2":
            view_tasks()
        elif choice == "3":
            view_tasks()
            try:
                index = int(input("Enter task number to mark as completed: "))
                complete_task(index)
            except ValueError:
                print("Invalid input. Please enter a number.")
        elif choice == "4":
            view_tasks()
            try:
                index = int(input("Enter task number to remove: "))
                remove_task(index)
            except ValueError:
                print("Invalid input. Please enter a number.")
        elif choice == "5":
            print("Exiting To-Do List Manager.")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()