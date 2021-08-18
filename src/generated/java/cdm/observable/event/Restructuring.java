package cdm.observable.event;

import cdm.observable.event.meta.RestructuringMeta;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum;
import cdm.observable.event.metafields.FieldWithMetaRestructuringEnum.FieldWithMetaRestructuringEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Restructuring extends RosettaModelObject {
	Restructuring build();
	Restructuring.RestructuringBuilder toBuilder();
	
	/**
	 * Indicates whether the restructuring provision is applicable.
	 */
	Boolean getApplicable();
	/**
	 * Presence of this element and value set to &#39;true&#39; indicates that Section 3.9 of the 2003 Credit Derivatives Definitions shall apply. Absence of this element indicates that Section 3.9 shall not apply. NOTE: Not allowed under ISDA Credit 1999.
	 */
	Boolean getMultipleCreditEventNotices();
	/**
	 * In relation to a restructuring credit event, unless multiple holder obligation is not specified restructurings are limited to multiple holder obligations. A multiple holder obligation means an obligation that is held by more than three holders that are not affiliates of each other and where at least two thirds of the holders must agree to the event that constitutes the restructuring credit event. ISDA 2003 Term: Multiple Holder Obligation.
	 */
	Boolean getMultipleHolderObligation();
	/**
	 * Specifies the type of restructuring that is applicable.
	 */
	FieldWithMetaRestructuringEnum getRestructuringType();
	final static RestructuringMeta metaData = new RestructuringMeta();
	
	@Override
	default RosettaMetaData<? extends Restructuring> metaData() {
		return metaData;
	} 
			
	static Restructuring.RestructuringBuilder builder() {
		return new Restructuring.RestructuringBuilderImpl();
	}
	
	default Class<? extends Restructuring> getType() {
		return Restructuring.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processor.processBasic(path.newSubPath("multipleCreditEventNotices"), Boolean.class, getMultipleCreditEventNotices(), this);
		processor.processBasic(path.newSubPath("multipleHolderObligation"), Boolean.class, getMultipleHolderObligation(), this);
		
		processRosetta(path.newSubPath("restructuringType"), processor, FieldWithMetaRestructuringEnum.class, getRestructuringType());
	}
	
	
	interface RestructuringBuilder extends Restructuring, RosettaModelObjectBuilder {
		FieldWithMetaRestructuringEnumBuilder getOrCreateRestructuringType();
		FieldWithMetaRestructuringEnumBuilder getRestructuringType();
		Restructuring.RestructuringBuilder setApplicable(Boolean applicable);
		Restructuring.RestructuringBuilder setMultipleCreditEventNotices(Boolean multipleCreditEventNotices);
		Restructuring.RestructuringBuilder setMultipleHolderObligation(Boolean multipleHolderObligation);
		Restructuring.RestructuringBuilder setRestructuringType(FieldWithMetaRestructuringEnum restructuringType);
		Restructuring.RestructuringBuilder setRestructuringTypeValue(RestructuringEnum restructuringType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processor.processBasic(path.newSubPath("multipleCreditEventNotices"), Boolean.class, getMultipleCreditEventNotices(), this);
			processor.processBasic(path.newSubPath("multipleHolderObligation"), Boolean.class, getMultipleHolderObligation(), this);
			
			processRosetta(path.newSubPath("restructuringType"), processor, FieldWithMetaRestructuringEnumBuilder.class, getRestructuringType());
		}
		
	}
	
	//Restructuring.RestructuringImpl
	class RestructuringImpl implements Restructuring {
		private final Boolean applicable;
		private final Boolean multipleCreditEventNotices;
		private final Boolean multipleHolderObligation;
		private final FieldWithMetaRestructuringEnum restructuringType;
		
		protected RestructuringImpl(Restructuring.RestructuringBuilder builder) {
			this.applicable = builder.getApplicable();
			this.multipleCreditEventNotices = builder.getMultipleCreditEventNotices();
			this.multipleHolderObligation = builder.getMultipleHolderObligation();
			this.restructuringType = ofNullable(builder.getRestructuringType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		public Boolean getMultipleCreditEventNotices() {
			return multipleCreditEventNotices;
		}
		
		@Override
		public Boolean getMultipleHolderObligation() {
			return multipleHolderObligation;
		}
		
		@Override
		public FieldWithMetaRestructuringEnum getRestructuringType() {
			return restructuringType;
		}
		
		@Override
		public Restructuring build() {
			return this;
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			Restructuring.RestructuringBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Restructuring.RestructuringBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getMultipleCreditEventNotices()).ifPresent(builder::setMultipleCreditEventNotices);
			ofNullable(getMultipleHolderObligation()).ifPresent(builder::setMultipleHolderObligation);
			ofNullable(getRestructuringType()).ifPresent(builder::setRestructuringType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Restructuring _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(multipleCreditEventNotices, _that.getMultipleCreditEventNotices())) return false;
			if (!Objects.equals(multipleHolderObligation, _that.getMultipleHolderObligation())) return false;
			if (!Objects.equals(restructuringType, _that.getRestructuringType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (multipleCreditEventNotices != null ? multipleCreditEventNotices.hashCode() : 0);
			_result = 31 * _result + (multipleHolderObligation != null ? multipleHolderObligation.hashCode() : 0);
			_result = 31 * _result + (restructuringType != null ? restructuringType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Restructuring {" +
				"applicable=" + this.applicable + ", " +
				"multipleCreditEventNotices=" + this.multipleCreditEventNotices + ", " +
				"multipleHolderObligation=" + this.multipleHolderObligation + ", " +
				"restructuringType=" + this.restructuringType +
			'}';
		}
	}
	
	//Restructuring.RestructuringBuilderImpl
	class RestructuringBuilderImpl implements Restructuring.RestructuringBuilder {
	
		protected Boolean applicable;
		protected Boolean multipleCreditEventNotices;
		protected Boolean multipleHolderObligation;
		protected FieldWithMetaRestructuringEnumBuilder restructuringType;
	
		public RestructuringBuilderImpl() {
		}
	
		@Override
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		public Boolean getMultipleCreditEventNotices() {
			return multipleCreditEventNotices;
		}
		
		@Override
		public Boolean getMultipleHolderObligation() {
			return multipleHolderObligation;
		}
		
		@Override
		public FieldWithMetaRestructuringEnumBuilder getRestructuringType() {
			return restructuringType;
		}
		
		@Override
		public FieldWithMetaRestructuringEnumBuilder getOrCreateRestructuringType() {
			FieldWithMetaRestructuringEnumBuilder result;
			if (restructuringType!=null) {
				result = restructuringType;
			}
			else {
				result = restructuringType = FieldWithMetaRestructuringEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Restructuring.RestructuringBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		public Restructuring.RestructuringBuilder setMultipleCreditEventNotices(Boolean multipleCreditEventNotices) {
			this.multipleCreditEventNotices = multipleCreditEventNotices==null?null:multipleCreditEventNotices;
			return this;
		}
		@Override
		public Restructuring.RestructuringBuilder setMultipleHolderObligation(Boolean multipleHolderObligation) {
			this.multipleHolderObligation = multipleHolderObligation==null?null:multipleHolderObligation;
			return this;
		}
		@Override
		public Restructuring.RestructuringBuilder setRestructuringType(FieldWithMetaRestructuringEnum restructuringType) {
			this.restructuringType = restructuringType==null?null:restructuringType.toBuilder();
			return this;
		}
		
		@Override
		public Restructuring.RestructuringBuilder setRestructuringTypeValue(RestructuringEnum restructuringType) {
			this.getOrCreateRestructuringType().setValue(restructuringType);
			return this;
		}
		
		@Override
		public Restructuring build() {
			return new Restructuring.RestructuringImpl(this);
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder prune() {
			if (restructuringType!=null && !restructuringType.prune().hasData()) restructuringType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getMultipleCreditEventNotices()!=null) return true;
			if (getMultipleHolderObligation()!=null) return true;
			if (getRestructuringType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Restructuring.RestructuringBuilder o = (Restructuring.RestructuringBuilder) other;
			
			merger.mergeRosetta(getRestructuringType(), o.getRestructuringType(), this::setRestructuringType);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			merger.mergeBasic(getMultipleCreditEventNotices(), o.getMultipleCreditEventNotices(), this::setMultipleCreditEventNotices);
			merger.mergeBasic(getMultipleHolderObligation(), o.getMultipleHolderObligation(), this::setMultipleHolderObligation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Restructuring _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(multipleCreditEventNotices, _that.getMultipleCreditEventNotices())) return false;
			if (!Objects.equals(multipleHolderObligation, _that.getMultipleHolderObligation())) return false;
			if (!Objects.equals(restructuringType, _that.getRestructuringType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (multipleCreditEventNotices != null ? multipleCreditEventNotices.hashCode() : 0);
			_result = 31 * _result + (multipleHolderObligation != null ? multipleHolderObligation.hashCode() : 0);
			_result = 31 * _result + (restructuringType != null ? restructuringType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringBuilder {" +
				"applicable=" + this.applicable + ", " +
				"multipleCreditEventNotices=" + this.multipleCreditEventNotices + ", " +
				"multipleHolderObligation=" + this.multipleHolderObligation + ", " +
				"restructuringType=" + this.restructuringType +
			'}';
		}
	}
}
