//linkedList implementation in C

#include <stdio.h>
#include <stdlib.h>
struct node
{

    int data;
    struct node *prev;
    struct node *next;

};

struct node *start;
struct node  *end;



void init_list()
{
    start=end=NULL; //  create a new list >> logically Empty!
}
struct node *create_node(int val)
{

    struct node *p;
    p =(struct node*)malloc(sizeof(struct node));
    p->data=val;
    p->next=NULL;
    p->prev=NULL;
    return p;
}
// Create node to be added later to the new list

void append_node(struct node*element)
{
    if ((start==NULL) && (end==NULL)) // empty list so the node will be the first one
    {
        start=element;
        end=element;
        element->next=NULL;
        element->prev=NULL;
    }
    else
    {
        element->prev = end;
        element->next = NULL;
        end->next = element;
        end = element;
    }
}
void insert_node(struct node*element)
{
    struct node *temp; // Aragooooooooooz
    temp=start;
    if ((start==NULL) && (end==NULL))
    {
        append_node(element);
    }
    else
    {
        while ((temp != NULL) && (temp->data < element->data))
        {
            temp = temp->next;
        }
        if ( (temp = NULL) ) // the last element in a not empty list
        {
            append_node(element);
        }
        else if((temp = start)) // the first element in a not empty list
        {
            start->prev=element;
            element->next=start;
            element->prev=NULL;
            start=element;
        }
        else // in between the current elements
        {
            temp->prev->next=element;
            element->prev=temp->prev;
            element->next=temp;
            temp->prev=element;
        }
    }

}
void print_list()
{
    struct node* temp;
    temp = start;
    while( (temp =! NULL) ) // as long as the list is not empty
    {
        printf("%d\n",temp->data);
        temp=temp->next;
    }
}
struct node* search_node(int d)
{
    struct node *temp;
    temp = start;
    while ((temp != NULL) && (temp->data =!d))
    {
        temp = temp->next;
    }
    return temp;
}




void find_node(int d) // additional
{
    struct node* find;
    find = search_node(d);
    if(find==NULL)
    {
        printf("%s","Data not found");
    }
    else
    {
        printf("\n%d",find->data);
    }
}





void delete_node(int d)
{
    struct node* temp;
    temp=search_node(d);
    if(temp==NULL)
    {
        printf("List is already empty\n");
    }
    if((start == end) && (start =! NULL)) // Just one element in the list
    {
        start=NULL;
        end = NULL;
        free(temp);
        printf("Deleted ...\n");
    }
    else if (temp==start) // the first element in the list
    {
        start = start->next;
        start->prev=NULL;
        free(temp);
        printf("Deleted ...\n");

    }
    else if (temp==end) //  the last element in the list
    {
        end->next=NULL;
        end=end->prev;
        free(temp);
        printf("Deleted ...\n");

    }
    else // in between
    {
        temp->prev->next=temp->next;
        temp->next->prev=temp->prev;
        free(temp);
        printf("Deleted ...\n");

    }
}

void destroy_list()
{
    struct node *temp;
    while(start!=NULL)
    {
        temp=start;
        start=start->next;
        free(temp);
    }
    end=NULL;
}

int main()
{
    init_list();
    create_node(1);
    insert_node(1);
    print_list();
    return 0;
}
