package cdm.legalagreement.contract;

import cdm.legalagreement.contract.meta.IssuerTradeIdMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for a two-parts identifier, such as a USI.
 * @version ${project.version}
 */
@RosettaClass

public interface IssuerTradeId extends RosettaModelObject {
	IssuerTradeId build();
	IssuerTradeId.IssuerTradeIdBuilder toBuilder();
	
	/**
	 * The identifier value. The CDM uses a neutral identifier attribute name rather than the FpML trade qualifier because of the focus that includes the pre-execution lifecycle, at which point a trade doesn&#39;t exist yet.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * The party that assigns the trade identifier.
	 */
	FieldWithMetaString getIssuer();
	final static IssuerTradeIdMeta metaData = new IssuerTradeIdMeta();
	
	@Override
	default RosettaMetaData<? extends IssuerTradeId> metaData() {
		return metaData;
	} 
			
	static IssuerTradeId.IssuerTradeIdBuilder builder() {
		return new IssuerTradeId.IssuerTradeIdBuilderImpl();
	}
	
	default Class<? extends IssuerTradeId> getType() {
		return IssuerTradeId.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier(), AttributeMeta.GLOBAL_KEY_FIELD);
		processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaString.class, getIssuer());
	}
	
	
	interface IssuerTradeIdBuilder extends IssuerTradeId, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIdentifier();
		FieldWithMetaStringBuilder getIdentifier();
		FieldWithMetaStringBuilder getOrCreateIssuer();
		FieldWithMetaStringBuilder getIssuer();
		IssuerTradeId.IssuerTradeIdBuilder setIdentifier(FieldWithMetaString identifier);
		IssuerTradeId.IssuerTradeIdBuilder setIdentifierValue(String identifier);
		IssuerTradeId.IssuerTradeIdBuilder setIssuer(FieldWithMetaString issuer);
		IssuerTradeId.IssuerTradeIdBuilder setIssuerValue(String issuer);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaStringBuilder.class, getIdentifier(), AttributeMeta.GLOBAL_KEY_FIELD);
			processRosetta(path.newSubPath("issuer"), processor, FieldWithMetaStringBuilder.class, getIssuer());
		}
		
	}
	
	//IssuerTradeId.IssuerTradeIdImpl
	class IssuerTradeIdImpl implements IssuerTradeId {
		private final FieldWithMetaString identifier;
		private final FieldWithMetaString issuer;
		
		protected IssuerTradeIdImpl(IssuerTradeId.IssuerTradeIdBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaString getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerTradeId build() {
			return this;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			IssuerTradeId.IssuerTradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerTradeId.IssuerTradeIdBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeId {" +
				"identifier=" + this.identifier + ", " +
				"issuer=" + this.issuer +
			'}';
		}
	}
	
	//IssuerTradeId.IssuerTradeIdBuilderImpl
	class IssuerTradeIdBuilderImpl implements IssuerTradeId.IssuerTradeIdBuilder {
	
		protected FieldWithMetaStringBuilder identifier;
		protected FieldWithMetaStringBuilder issuer;
	
		public IssuerTradeIdBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIssuer() {
			FieldWithMetaStringBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setIssuer(FieldWithMetaString issuer) {
			this.issuer = issuer==null?null:issuer.toBuilder();
			return this;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder setIssuerValue(String issuer) {
			this.getOrCreateIssuer().setValue(issuer);
			return this;
		}
		
		@Override
		public IssuerTradeId build() {
			return new IssuerTradeId.IssuerTradeIdImpl(this);
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getIssuer()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerTradeId.IssuerTradeIdBuilder o = (IssuerTradeId.IssuerTradeIdBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerTradeId _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerTradeIdBuilder {" +
				"identifier=" + this.identifier + ", " +
				"issuer=" + this.issuer +
			'}';
		}
	}
}
