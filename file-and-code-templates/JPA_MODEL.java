package ${PACKAGE_NAME};

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "${DB_NAME}")
public class ${NAME} {
/*
!!!!!!!!!!!!!!!!!!!!!!!
    DO
        NOT
    FORGET
        TO
    GENERATE
        EQUALS
    TOSTRING
        AND 
    HASHCODE
!!!!!!!!!!!!!!!!!!!!!!!
*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ${DB_NAME}Id;
    #if (${TYPE1} != "")private ${TYPE1} ${V1};#end
    #if (${TYPE2} != "")private ${TYPE2} ${V2};#end
    #if (${TYPE3} != "")private ${TYPE3} ${V3};#end    
    #if (${TYPE4} != "")private ${TYPE4} ${V4};#end    
    #if (${TYPE5} != "")private ${TYPE5} ${V5};#end    
    #if (${TYPE6} != "")private ${TYPE6} ${V6};#end
    #if (${TYPE7} != "")private ${TYPE7} ${V7};#end
    #if (${TYPE8} != "")private ${TYPE8} ${V8};#end
    #if (${TYPE9} != "")private ${TYPE9} ${V9};#end
    #if (${TYPE10} != "")private ${TYPE10} ${V10};#end

    //@OneToMany(mappedBy = note_id, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Set<Note> notes;

    public ${NAME}() {
    }

    public ${NAME}(#if (${TYPE1} != "")${TYPE1} ${V1}#end #if (${TYPE2} != ""), ${TYPE2} ${V2}#end #if (${TYPE3} != ""), ${TYPE3} ${V3}#end #if (${TYPE4} != ""),${TYPE4} ${V4}#end #if (${TYPE5} != ""),${TYPE5} ${V5}#end #if (${TYPE6} != ""),${TYPE6} ${V6}#end #if (${TYPE7} != ""),${TYPE7} ${V7}#end #if (${TYPE8} != ""),${TYPE8} ${V8}#end #if (${TYPE} != ""),${TYPE9} ${V9}#end #if (${TYPE10} != ""),${TYPE10} ${V10}#end) {
        #if (${TYPE1} != "")this.${V1} = ${V1};#end
        #if (${TYPE2} != "")this.${V2} = ${V2};#end
        #if (${TYPE3} != "")this.${V3} = ${V3};#end
        #if (${TYPE4} != "")this.${V4} = ${V4};#end
        #if (${TYPE5} != "")this.${V5} = ${V5};#end
        #if (${TYPE6} != "")this.${V6} = ${V6};#end
        #if (${TYPE7} != "")this.${V7} = ${V7};#end
        #if (${TYPE8} != "")this.${V8} = ${V8};#end
        #if (${TYPE9} != "")this.${V9} = ${V9};#end
        #if (${TYPE10} != "")this.${V10} = ${V10};#end
    }

    public ${NAME}(Integer ${NAME}Id #if (${TYPE1} != ""),${TYPE1} ${V1}#end #if (${TYPE2} != ""),${TYPE2} ${V2}#end #if (${TYPE3} != ""),${TYPE3} ${V3}#end #if (${TYPE4} != ""),${TYPE4} ${V4}#end #if (${TYPE5} != ""),${TYPE5} ${V5}#end #if (${TYPE6} != ""),${TYPE6} ${V6}#end #if (${TYPE7} != ""),${TYPE7} ${V7}#end #if (${TYPE8} != ""),${TYPE8} ${V8}#end #if (${TYPE} != ""),${TYPE9} ${V9}#end #if (${TYPE10} != ""),${TYPE10} ${V10}#end) {
        this.${DB_NAME}Id = ${DB_NAME}Id;
        #if (${TYPE1} != "")this.${V1} = ${V1};#end
        #if (${TYPE2} != "")this.${V2} = ${V2};#end
        #if (${TYPE3} != "")this.${V3} = ${V3};#end
        #if (${TYPE4} != "")this.${V4} = ${V4};#end
        #if (${TYPE5} != "")this.${V5} = ${V5};#end
        #if (${TYPE6} != "")this.${V6} = ${V6};#end
        #if (${TYPE7} != "")this.${V7} = ${V7};#end
        #if (${TYPE8} != "")this.${V8} = ${V8};#end
        #if (${TYPE9} != "")this.${V9} = ${V9};#end
        #if (${TYPE10} != "")this.${V10} = ${V10};#end
    }

    public Integer get${NAME}Id() {
        return ${DB_NAME}Id;
    }

    public void set${NAME}Id(Integer ${DB_NAME}Id) {
        this.${DB_NAME}Id = ${DB_NAME}Id;
    }

    #if (${TYPE1} != "")public ${TYPE1} get${V1}() {
        return ${V1};
    }#end

    #if (${TYPE1} != "")public void set${V1}(${TYPE1} ${V1}) {
        this.${V1} = ${V1};
    }#end

    #if (${TYPE2} != "")public ${TYPE2} get${V2}() {
        return ${V2};
    }#end

    #if (${TYPE2} != "")public void set${V2}(${TYPE2} ${V2}) {
        this.${V2} = ${V2};
    }#end

    #if (${TYPE3} != "")public ${TYPE3} get${V3}() {
        return ${V3};
    }#end

    #if (${TYPE3} != "")public void set${V3}(${TYPE3} ${V3}) {
        this.${V3} = ${V3};
    }#end

    #if (${TYPE4} != "")public ${TYPE4} get${V4}() {
        return ${V4};
    }#end

    #if (${TYPE4} != "")public void set${V4}(${TYPE4} ${V4}) {
        this.${V4} = ${V4};
    }#end

    #if (${TYPE5} != "")public ${TYPE5} get${V5}() {
        return ${V5};
    }#end

    #if (${TYPE5} != "")public void set${V5}(${TYPE5} ${V5}) {
        this.${V5} = ${V5};
    }#end

    #if (${TYPE6} != "")public ${TYPE6} get${V6}() {
        return ${V6};
    }#end

    #if (${TYPE6} != "")public void set${V6}(${TYPE6} ${V6}) {
        this.${V6} = ${V6};
    }#end
    
    #if (${TYPE7} != "")public ${TYPE7} get${V7}() {
        return ${V7};
    }#end

    #if (${TYPE7} != "")public void set${V7}(${TYPE7} ${V7}) {
        this.${V7} = ${V7};
    }#end
    
    #if (${TYPE8} != "")public ${TYPE8} get${V8}() {
        return ${V8};
    }#end

    #if (${TYPE8} != "")public void set${V8}(${TYPE8} ${V8}) {
        this.${V8} = ${V8};
    }#end
    
    #if (${TYPE9} != "")public ${TYPE9} get${V9}() {
        return ${V9};
    }#end

    #if (${TYPE9} != "")public void set${V9}(${TYPE9} ${V9}) {
        this.${V9} = ${V9};
    }#end
    
    #if (${TYPE10} != "")public ${TYPE10} get${V10}() {
        return ${V10};
    }#end

    #if (${TYPE10} != "")public void set${V10}(${TYPE10} ${V10}) {
        this.${V10} = ${V10};
    }#end
}
