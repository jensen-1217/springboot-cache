package com.itheima.cache.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName role
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String rolename;
    /**

     *
     */
    private String rolecode;

    /**
     * 
     */
    private String introduce;

    private static final long serialVersionUID = 1L;
}