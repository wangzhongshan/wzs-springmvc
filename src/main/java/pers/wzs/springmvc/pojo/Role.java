package pers.wzs.springmvc.pojo;

import javax.persistence.Id;
import java.util.Date;

/**
 * role
 */
public class Role extends BaseModel {
    @Id
    private Long id;

    /** 角色名称 */
    private String name;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date ctm;

    /** 更改时间 */
    private Date utm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCtm() {
        return ctm;
    }

    public void setCtm(Date ctm) {
        this.ctm = ctm;
    }

    public Date getUtm() {
        return utm;
    }

    public void setUtm(Date utm) {
        this.utm = utm;
    }
}