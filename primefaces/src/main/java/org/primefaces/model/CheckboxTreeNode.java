/*
 * Copyright 2009,2010 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CheckboxTreeNode implements TreeNode, Serializable {
	
	public static final String DEFAULT_TYPE = "default";
	
	private String type;
	
	private Object data;
	
	private List<TreeNode> children;
	
	private TreeNode parent;
	
	private boolean expanded;

    private boolean selected;
    
    private boolean selectable = true;
    
    private boolean partialSelected;
    
    private String rowKey;
	
	public CheckboxTreeNode() {
        this.type = DEFAULT_TYPE;
        this.children = new TreeNodeChildren(this);
    }
    
    public CheckboxTreeNode(Object data) {
		this.type = DEFAULT_TYPE;
        this.children = new TreeNodeChildren(this);
		this.data = data;
	}

	public CheckboxTreeNode(Object data, TreeNode parent) {
		this.type = DEFAULT_TYPE;
		this.data = data;
		this.children = new TreeNodeChildren(this);
		if(parent != null) { 
            parent.getChildren().add(this);
        }
	}
	
	public CheckboxTreeNode(String type, Object data, TreeNode parent) {
		this.type = type;
		this.data = data;
		this.children = new TreeNodeChildren(this);
		if(parent != null) { 
            parent.getChildren().add(this);
        }
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public List<TreeNode> getChildren() {
		return children;
	}
	
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
        if(this.parent != null) {
            this.parent.getChildren().remove(this);
        }
        
        this.parent = parent;
	}
	
	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
        this.partialSelected = false;
        
        if(!isLeaf()) {
            for(TreeNode child : children) {
                ((CheckboxTreeNode) child).propagateSelectionDown(value);
            }
        }
        
        if(this.getParent() != null) {
            ((CheckboxTreeNode) this.getParent()).propagateSelectionUp();
        }
    }
    
    protected void propagateSelectionDown(boolean value) {
        this.selected = value;
        
        for(TreeNode child : children) {
            ((CheckboxTreeNode) child).propagateSelectionDown(value);
        }
    }
    
    protected void propagateSelectionUp() {
        boolean allChildrenSelected = true;
        
        for(int i=0; i < this.getChildren().size(); i++) {  
            boolean childSelected = this.getChildren().get(i).isSelected();
            boolean childPartialSelected = this.getChildren().get(i).isPartialSelected();
            allChildrenSelected = allChildrenSelected && childSelected;
            partialSelected = partialSelected||childSelected||childPartialSelected;
        }
        
        if(allChildrenSelected) {
            this.selected = true;
        }
        
        if(this.getParent() != null) {
            ((CheckboxTreeNode) this.getParent()).propagateSelectionUp();
        }
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
    
	public int getChildCount() {
		return children.size();
	}

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }
    
	public boolean isLeaf() {
		if(children == null)
			return true;
		
		return children.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		TreeNode other = (TreeNode) obj;
		if (data == null) {
			if (other.getData() != null)
				return false;
		} else if (!data.equals(other.getData()))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		if(data != null)
			return data.toString();
		else
			return super.toString();
	}	

    public boolean isPartialSelected() {
        return partialSelected;
    }

    public void setPartialSelected(boolean value) {
        this.partialSelected = value;
    }
}