package com.dayNineteen;

public class Rule {

    public String left;
    public String right = "";
    public Boolean checked;
    public Boolean hasRight = false;

    public Rule() {
        this.checked = false;
    }

    public void setLeftRule(String leftRule) {
        this.left = leftRule;
    }

    public void setRightRule(String rightRule) {
        this.right = rightRule;
    }

}
