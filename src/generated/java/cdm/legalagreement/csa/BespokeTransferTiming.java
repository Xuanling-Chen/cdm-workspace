package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.BespokeTransferTimingMeta;
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
 * A class to specify any bespoke Transfer Timing language by each party to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface BespokeTransferTiming extends RosettaModelObject {
	BespokeTransferTiming build();
	BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder();
	
	/**
	 * The bespoke transfer timing terms applicable to the agreement
	 */
	String getBespokeTransferTimingTerms();
	/**
	 * A boolean flag to specify whether bespoke transfer terms are applicable or not.
	 */
	Boolean getIsApplicable();
	final static BespokeTransferTimingMeta metaData = new BespokeTransferTimingMeta();
	
	@Override
	default RosettaMetaData<? extends BespokeTransferTiming> metaData() {
		return metaData;
	} 
			
	static BespokeTransferTiming.BespokeTransferTimingBuilder builder() {
		return new BespokeTransferTiming.BespokeTransferTimingBuilderImpl();
	}
	
	default Class<? extends BespokeTransferTiming> getType() {
		return BespokeTransferTiming.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bespokeTransferTimingTerms"), String.class, getBespokeTransferTimingTerms(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
	}
	
	
	interface BespokeTransferTimingBuilder extends BespokeTransferTiming, RosettaModelObjectBuilder {
		BespokeTransferTiming.BespokeTransferTimingBuilder setBespokeTransferTimingTerms(String bespokeTransferTimingTerms);
		BespokeTransferTiming.BespokeTransferTimingBuilder setIsApplicable(Boolean isApplicable);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bespokeTransferTimingTerms"), String.class, getBespokeTransferTimingTerms(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
		}
		
	}
	
	//BespokeTransferTiming.BespokeTransferTimingImpl
	class BespokeTransferTimingImpl implements BespokeTransferTiming {
		private final String bespokeTransferTimingTerms;
		private final Boolean isApplicable;
		
		protected BespokeTransferTimingImpl(BespokeTransferTiming.BespokeTransferTimingBuilder builder) {
			this.bespokeTransferTimingTerms = builder.getBespokeTransferTimingTerms();
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		public String getBespokeTransferTimingTerms() {
			return bespokeTransferTimingTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public BespokeTransferTiming build() {
			return this;
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder() {
			BespokeTransferTiming.BespokeTransferTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeTransferTiming.BespokeTransferTimingBuilder builder) {
			ofNullable(getBespokeTransferTimingTerms()).ifPresent(builder::setBespokeTransferTimingTerms);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(bespokeTransferTimingTerms, _that.getBespokeTransferTimingTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeTransferTimingTerms != null ? bespokeTransferTimingTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeTransferTiming {" +
				"bespokeTransferTimingTerms=" + this.bespokeTransferTimingTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
	
	//BespokeTransferTiming.BespokeTransferTimingBuilderImpl
	class BespokeTransferTimingBuilderImpl implements BespokeTransferTiming.BespokeTransferTimingBuilder {
	
		protected String bespokeTransferTimingTerms;
		protected Boolean isApplicable;
	
		public BespokeTransferTimingBuilderImpl() {
		}
	
		@Override
		public String getBespokeTransferTimingTerms() {
			return bespokeTransferTimingTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
	
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder setBespokeTransferTimingTerms(String bespokeTransferTimingTerms) {
			this.bespokeTransferTimingTerms = bespokeTransferTimingTerms==null?null:bespokeTransferTimingTerms;
			return this;
		}
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		
		@Override
		public BespokeTransferTiming build() {
			return new BespokeTransferTiming.BespokeTransferTimingImpl(this);
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBespokeTransferTimingTerms()!=null) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeTransferTiming.BespokeTransferTimingBuilder o = (BespokeTransferTiming.BespokeTransferTimingBuilder) other;
			
			
			merger.mergeBasic(getBespokeTransferTimingTerms(), o.getBespokeTransferTimingTerms(), this::setBespokeTransferTimingTerms);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(bespokeTransferTimingTerms, _that.getBespokeTransferTimingTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bespokeTransferTimingTerms != null ? bespokeTransferTimingTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeTransferTimingBuilder {" +
				"bespokeTransferTimingTerms=" + this.bespokeTransferTimingTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
