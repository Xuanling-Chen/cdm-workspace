package cdm.product.common.settlement;

import cdm.product.common.settlement.meta.PrincipalExchangesMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining which principal exchanges occur for the stream.
 * @version ${project.version}
 */
@RosettaClass

public interface PrincipalExchanges extends RosettaModelObject, GlobalKey {
	PrincipalExchanges build();
	PrincipalExchanges.PrincipalExchangesBuilder toBuilder();
	
	/**
	 * A true/false flag to indicate whether there is a final exchange of principal on the termination date.
	 */
	Boolean getFinalExchange();
	/**
	 * A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
	 */
	Boolean getInitialExchange();
	/**
	 * A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
	 */
	Boolean getIntermediateExchange();
	/**
	 */
	MetaFields getMeta();
	final static PrincipalExchangesMeta metaData = new PrincipalExchangesMeta();
	
	@Override
	default RosettaMetaData<? extends PrincipalExchanges> metaData() {
		return metaData;
	} 
			
	static PrincipalExchanges.PrincipalExchangesBuilder builder() {
		return new PrincipalExchanges.PrincipalExchangesBuilderImpl();
	}
	
	default Class<? extends PrincipalExchanges> getType() {
		return PrincipalExchanges.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
		processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
		processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface PrincipalExchangesBuilder extends PrincipalExchanges, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean finalExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean initialExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean intermediateExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
			processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
			processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//PrincipalExchanges.PrincipalExchangesImpl
	class PrincipalExchangesImpl implements PrincipalExchanges {
		private final Boolean finalExchange;
		private final Boolean initialExchange;
		private final Boolean intermediateExchange;
		private final MetaFields meta;
		
		protected PrincipalExchangesImpl(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			this.finalExchange = builder.getFinalExchange();
			this.initialExchange = builder.getInitialExchange();
			this.intermediateExchange = builder.getIntermediateExchange();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PrincipalExchanges build() {
			return this;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			PrincipalExchanges.PrincipalExchangesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			ofNullable(getFinalExchange()).ifPresent(builder::setFinalExchange);
			ofNullable(getInitialExchange()).ifPresent(builder::setInitialExchange);
			ofNullable(getIntermediateExchange()).ifPresent(builder::setIntermediateExchange);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchanges {" +
				"finalExchange=" + this.finalExchange + ", " +
				"initialExchange=" + this.initialExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//PrincipalExchanges.PrincipalExchangesBuilderImpl
	class PrincipalExchangesBuilderImpl implements PrincipalExchanges.PrincipalExchangesBuilder, GlobalKeyBuilder {
	
		protected Boolean finalExchange;
		protected Boolean initialExchange;
		protected Boolean intermediateExchange;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public PrincipalExchangesBuilderImpl() {
		}
	
		@Override
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean finalExchange) {
			this.finalExchange = finalExchange==null?null:finalExchange;
			return this;
		}
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean initialExchange) {
			this.initialExchange = initialExchange==null?null:initialExchange;
			return this;
		}
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean intermediateExchange) {
			this.intermediateExchange = intermediateExchange==null?null:intermediateExchange;
			return this;
		}
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchanges build() {
			return new PrincipalExchanges.PrincipalExchangesImpl(this);
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinalExchange()!=null) return true;
			if (getInitialExchange()!=null) return true;
			if (getIntermediateExchange()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchanges.PrincipalExchangesBuilder o = (PrincipalExchanges.PrincipalExchangesBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getFinalExchange(), o.getFinalExchange(), this::setFinalExchange);
			merger.mergeBasic(getInitialExchange(), o.getInitialExchange(), this::setInitialExchange);
			merger.mergeBasic(getIntermediateExchange(), o.getIntermediateExchange(), this::setIntermediateExchange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangesBuilder {" +
				"finalExchange=" + this.finalExchange + ", " +
				"initialExchange=" + this.initialExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
