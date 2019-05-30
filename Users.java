/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_2;

import java.util.ArrayList;

public class Users
{
    private class User
    {
	private String name;
	private int id;
	private ArrayList<String> books;

	public User(String name, int id)
        {
            this.name = name;
            this.id = id;
            books = new ArrayList<>();
	}

        //Getters    
	public int getId() 
        {
            return id;
        }
	public String getName() 
        {
            return name;
        }
	public ArrayList<String> getCheckedOutBooks() 
        {
            return books;
        }
    }
    private ArrayList<User> users;

    //Constructor for Users public class
    public Users() 
    {
        users = new ArrayList<User>();
    }

    public String addUser(String name, int id) 
    {
	try
        {
            User tmp = new User(name, id);
            users.add(tmp);
            return "User added!";
	} 
        catch(Exception e) 
        {
            return "Error adding user: " + e;
	}
    }

    // Show users
    public String displayUsers() 
    {
	String ans = "";
	for(User u : users) 
        {
            ans += u.getName() + ", id: " + u.getId() + ".\n";
	}
	return ans;
    }

    // calls binary search, and decides what to return depending on return value
    public String searchById(int id)
    {
	String ans = binarySearch(0, users.size()-1, id);
	if(ans == null)
        {
            return "User not found!";
        }
	else
        {
            return ans;
        }
    }

    // binary search performed on the already sorted users arrayList.
    private String binarySearch(int start, int end, int target)
    {
	if(start > end)
        {
            return null;
	}
	int mid = start + (end-start)/2;
	//System.out.println("start: " + start + ", mid: " + mid +", end: " + end);
	if(users.get(mid).getId() == target) 
        {
            return users.get(mid).getName();
        }
	if(target > users.get(mid).getId())
        {
            return binarySearch(mid+1, end, target);
        }
	else return binarySearch(start, mid-1, target);
    }


    // Sort users by id, call quickSort
    public void sortUsers()
    {
	quickSort(0, users.size()-1);
    }

    // quicksort
    private void quickSort(int lo, int hi)
    {
	// if the the part of the array has already been sorted
	if(lo >= hi)
        {
            return;
        }
	int p = partition(lo, hi);
	quickSort(lo, p-1);
	quickSort(p+1, hi);
    }

    /* 
    * To find out where the index of partition will be.
    * For simplicity purposes we will always choose pivot to be the last element,
    * but the effiency could be improved by choosing a random pivot.
    */
    private int partition(int lo, int hi)
    {
	int i = lo;
	for(int j = i; j < hi; j++)
        {
            if(users.get(j).getId() < users.get(hi).getId())
            {
		swap(i, j);
		i++;
            }
	}
	swap(i, hi);
	return i;
    }

    // to swap elements in the users array list
    private void swap(int i, int j)
    {
        User tmp = users.get(i);
	users.set(i, users.get(j));
	users.set(j, tmp);
    }
}
