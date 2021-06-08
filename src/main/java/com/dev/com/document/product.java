/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.com.document;

import org.bson.types.ObjectId;

/**
 *
 * @author tamvo
 */
public class product {
    private ObjectId id;
    private String name;
    private String price;
    private ObjectId category_Id;
    private ObjectId user_Id;
    private Integer useCount = 0;
}
