package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.ReferenceBankMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to describe an institution (party) identified by means of a coding scheme and an optional name.
 * @version ${project.version}
 */
@RosettaClass

public interface ReferenceBank extends RosettaModelObject {
	ReferenceBank build();
	ReferenceBank.ReferenceBankBuilder toBuilder();
	
	/**
	 * An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.
	 */
	FieldWithMetaString getReferenceBankId();
	/**
	 * The name of the institution (party). A free format string. FpML does not define usage rules for the element.
	 */
	String getReferenceBankName();
	final static ReferenceBankMeta metaData = new ReferenceBankMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceBank> metaData() {
		return metaData;
	} 
			
	static ReferenceBank.ReferenceBankBuilder builder() {
		return new ReferenceBank.ReferenceBankBuilderImpl();
	}
	
	default Class<? extends ReferenceBank> getType() {
		return ReferenceBank.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("referenceBankName"), String.class, getReferenceBankName(), this);
		
		processRosetta(path.newSubPath("referenceBankId"), processor, FieldWithMetaString.class, getReferenceBankId());
	}
	
	
	interface ReferenceBankBuilder extends ReferenceBank, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateReferenceBankId();
		FieldWithMetaStringBuilder getReferenceBankId();
		ReferenceBank.ReferenceBankBuilder setReferenceBankId(FieldWithMetaString referenceBankId);
		ReferenceBank.ReferenceBankBuilder setReferenceBankIdValue(String referenceBankId);
		ReferenceBank.ReferenceBankBuilder setReferenceBankName(String referenceBankName);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("referenceBankName"), String.class, getReferenceBankName(), this);
			
			processRosetta(path.newSubPath("referenceBankId"), processor, FieldWithMetaStringBuilder.class, getReferenceBankId());
		}
		
	}
	
	//ReferenceBank.ReferenceBankImpl
	class ReferenceBankImpl implements ReferenceBank {
		private final FieldWithMetaString referenceBankId;
		private final String referenceBankName;
		
		protected ReferenceBankImpl(ReferenceBank.ReferenceBankBuilder builder) {
			this.referenceBankId = ofNullable(builder.getReferenceBankId()).map(f->f.build()).orElse(null);
			this.referenceBankName = builder.getReferenceBankName();
		}
		
		@Override
		public FieldWithMetaString getReferenceBankId() {
			return referenceBankId;
		}
		
		@Override
		public String getReferenceBankName() {
			return referenceBankName;
		}
		
		@Override
		public ReferenceBank build() {
			return this;
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder toBuilder() {
			ReferenceBank.ReferenceBankBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceBank.ReferenceBankBuilder builder) {
			ofNullable(getReferenceBankId()).ifPresent(builder::setReferenceBankId);
			ofNullable(getReferenceBankName()).ifPresent(builder::setReferenceBankName);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBank _that = getType().cast(o);
		
			if (!Objects.equals(referenceBankId, _that.getReferenceBankId())) return false;
			if (!Objects.equals(referenceBankName, _that.getReferenceBankName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBankId != null ? referenceBankId.hashCode() : 0);
			_result = 31 * _result + (referenceBankName != null ? referenceBankName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBank {" +
				"referenceBankId=" + this.referenceBankId + ", " +
				"referenceBankName=" + this.referenceBankName +
			'}';
		}
	}
	
	//ReferenceBank.ReferenceBankBuilderImpl
	class ReferenceBankBuilderImpl implements ReferenceBank.ReferenceBankBuilder {
	
		protected FieldWithMetaStringBuilder referenceBankId;
		protected String referenceBankName;
	
		public ReferenceBankBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getReferenceBankId() {
			return referenceBankId;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateReferenceBankId() {
			FieldWithMetaStringBuilder result;
			if (referenceBankId!=null) {
				result = referenceBankId;
			}
			else {
				result = referenceBankId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getReferenceBankName() {
			return referenceBankName;
		}
		
	
		@Override
		public ReferenceBank.ReferenceBankBuilder setReferenceBankId(FieldWithMetaString referenceBankId) {
			this.referenceBankId = referenceBankId==null?null:referenceBankId.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder setReferenceBankIdValue(String referenceBankId) {
			this.getOrCreateReferenceBankId().setValue(referenceBankId);
			return this;
		}
		@Override
		public ReferenceBank.ReferenceBankBuilder setReferenceBankName(String referenceBankName) {
			this.referenceBankName = referenceBankName==null?null:referenceBankName;
			return this;
		}
		
		@Override
		public ReferenceBank build() {
			return new ReferenceBank.ReferenceBankImpl(this);
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBank.ReferenceBankBuilder prune() {
			if (referenceBankId!=null && !referenceBankId.prune().hasData()) referenceBankId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceBankId()!=null) return true;
			if (getReferenceBankName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBank.ReferenceBankBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceBank.ReferenceBankBuilder o = (ReferenceBank.ReferenceBankBuilder) other;
			
			merger.mergeRosetta(getReferenceBankId(), o.getReferenceBankId(), this::setReferenceBankId);
			
			merger.mergeBasic(getReferenceBankName(), o.getReferenceBankName(), this::setReferenceBankName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBank _that = getType().cast(o);
		
			if (!Objects.equals(referenceBankId, _that.getReferenceBankId())) return false;
			if (!Objects.equals(referenceBankName, _that.getReferenceBankName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceBankId != null ? referenceBankId.hashCode() : 0);
			_result = 31 * _result + (referenceBankName != null ? referenceBankName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBankBuilder {" +
				"referenceBankId=" + this.referenceBankId + ", " +
				"referenceBankName=" + this.referenceBankName +
			'}';
		}
	}
}
