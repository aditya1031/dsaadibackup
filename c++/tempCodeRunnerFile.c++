//aditya kumar
//21bcs9520

#include <iostream>

struct Node {
    int data;
    Node* next;
};

bool isCircular(Node* head) {
    if (head == nullptr)
        return false;

    Node* slow = head;
    Node* fast = head;

    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;

        
        if (slow == fast)
            return true;
    }

   
    return false;
}

int main() {
   
    Node* head = new Node{1, nullptr};
    head->next = new Node{2, nullptr};
    head->next->next = new Node{3, nullptr};
    head->next->next->next = head; 

    if (isCircular(head))
        std::cout << "Linked list is circular\n";
    else
        std::cout << "Linked list is not circular\n";

    
    delete head->next->next->next;
    delete head->next->next;
    delete head->next;
    delete head;

    return 0;
}
