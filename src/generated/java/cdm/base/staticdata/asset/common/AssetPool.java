package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.AssetPoolMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Characterizes the asset pool behind an asset backed bond.
 * @version ${project.version}
 */
@RosettaClass

public interface AssetPool extends RosettaModelObject {
	AssetPool build();
	AssetPool.AssetPoolBuilder toBuilder();
	
	/**
	 * The part of the mortgage that is currently outstanding. It is expressed similarly to the initial factor, as factor multiplier to the mortgage. This term is formally defined as part of the &#39;ISDA Standard Terms Supplement for use with credit derivatives transactions on mortgage-backed security with pas-as-you-go or physical settlement&#39;.
	 */
	BigDecimal getCurrentFactor();
	/**
	 * Optionally it is possible to specify a version effective date when a version is supplied.
	 */
	Date getEffectiveDate();
	/**
	 * The part of the mortgage that is outstanding on trade inception, i.e. has not been repaid yet as principal. It is expressed as a multiplier factor to the mortgage: 1 means that the whole mortgage amount is outstanding, 0.8 means that 20% has been repaid.
	 */
	BigDecimal getInitialFactor();
	/**
	 * The asset pool version.
	 */
	String getVersion();
	final static AssetPoolMeta metaData = new AssetPoolMeta();
	
	@Override
	default RosettaMetaData<? extends AssetPool> metaData() {
		return metaData;
	} 
			
	static AssetPool.AssetPoolBuilder builder() {
		return new AssetPool.AssetPoolBuilderImpl();
	}
	
	default Class<? extends AssetPool> getType() {
		return AssetPool.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
		processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
		
	}
	
	
	interface AssetPoolBuilder extends AssetPool, RosettaModelObjectBuilder {
		AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal currentFactor);
		AssetPool.AssetPoolBuilder setEffectiveDate(Date effectiveDate);
		AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal initialFactor);
		AssetPool.AssetPoolBuilder setVersion(String version);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
			processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
			
		}
		
	}
	
	//AssetPool.AssetPoolImpl
	class AssetPoolImpl implements AssetPool {
		private final BigDecimal currentFactor;
		private final Date effectiveDate;
		private final BigDecimal initialFactor;
		private final String version;
		
		protected AssetPoolImpl(AssetPool.AssetPoolBuilder builder) {
			this.currentFactor = builder.getCurrentFactor();
			this.effectiveDate = builder.getEffectiveDate();
			this.initialFactor = builder.getInitialFactor();
			this.version = builder.getVersion();
		}
		
		@Override
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		public String getVersion() {
			return version;
		}
		
		@Override
		public AssetPool build() {
			return this;
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			AssetPool.AssetPoolBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetPool.AssetPoolBuilder builder) {
			ofNullable(getCurrentFactor()).ifPresent(builder::setCurrentFactor);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getInitialFactor()).ifPresent(builder::setInitialFactor);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPool {" +
				"currentFactor=" + this.currentFactor + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"version=" + this.version +
			'}';
		}
	}
	
	//AssetPool.AssetPoolBuilderImpl
	class AssetPoolBuilderImpl implements AssetPool.AssetPoolBuilder {
	
		protected BigDecimal currentFactor;
		protected Date effectiveDate;
		protected BigDecimal initialFactor;
		protected String version;
	
		public AssetPoolBuilderImpl() {
		}
	
		@Override
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@Override
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		public String getVersion() {
			return version;
		}
		
	
		@Override
		public AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal currentFactor) {
			this.currentFactor = currentFactor==null?null:currentFactor;
			return this;
		}
		@Override
		public AssetPool.AssetPoolBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		public AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal initialFactor) {
			this.initialFactor = initialFactor==null?null:initialFactor;
			return this;
		}
		@Override
		public AssetPool.AssetPoolBuilder setVersion(String version) {
			this.version = version==null?null:version;
			return this;
		}
		
		@Override
		public AssetPool build() {
			return new AssetPool.AssetPoolImpl(this);
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrentFactor()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getInitialFactor()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetPool.AssetPoolBuilder o = (AssetPool.AssetPoolBuilder) other;
			
			
			merger.mergeBasic(getCurrentFactor(), o.getCurrentFactor(), this::setCurrentFactor);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getInitialFactor(), o.getInitialFactor(), this::setInitialFactor);
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPoolBuilder {" +
				"currentFactor=" + this.currentFactor + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"version=" + this.version +
			'}';
		}
	}
}
