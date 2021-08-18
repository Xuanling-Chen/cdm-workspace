package cdm.base.staticdata.identifier;

import cdm.base.staticdata.identifier.meta.AssignedIdentifierMeta;
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
 * A class to specify the identifier value and its associated version.
 * @version ${project.version}
 */
@RosettaClass

public interface AssignedIdentifier extends RosettaModelObject {
	AssignedIdentifier build();
	AssignedIdentifier.AssignedIdentifierBuilder toBuilder();
	
	/**
	 * The identifier value.
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * The identifier version, which is specified as an integer and is meant to be incremented each time the transaction terms (whether contract or event) change. This version is made option to support the use case where the identifier is referenced without the version. The constraint that a contract and a lifecycle event need to have an associated version is enforced through data rules.
	 */
	Integer getVersion();
	final static AssignedIdentifierMeta metaData = new AssignedIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends AssignedIdentifier> metaData() {
		return metaData;
	} 
			
	static AssignedIdentifier.AssignedIdentifierBuilder builder() {
		return new AssignedIdentifier.AssignedIdentifierBuilderImpl();
	}
	
	default Class<? extends AssignedIdentifier> getType() {
		return AssignedIdentifier.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
	}
	
	
	interface AssignedIdentifierBuilder extends AssignedIdentifier, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIdentifier();
		FieldWithMetaStringBuilder getIdentifier();
		AssignedIdentifier.AssignedIdentifierBuilder setIdentifier(FieldWithMetaString identifier);
		AssignedIdentifier.AssignedIdentifierBuilder setIdentifierValue(String identifier);
		AssignedIdentifier.AssignedIdentifierBuilder setVersion(Integer version);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaStringBuilder.class, getIdentifier());
		}
		
	}
	
	//AssignedIdentifier.AssignedIdentifierImpl
	class AssignedIdentifierImpl implements AssignedIdentifier {
		private final FieldWithMetaString identifier;
		private final Integer version;
		
		protected AssignedIdentifierImpl(AssignedIdentifier.AssignedIdentifierBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
		}
		
		@Override
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		public Integer getVersion() {
			return version;
		}
		
		@Override
		public AssignedIdentifier build() {
			return this;
		}
		
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder toBuilder() {
			AssignedIdentifier.AssignedIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssignedIdentifier.AssignedIdentifierBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssignedIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssignedIdentifier {" +
				"identifier=" + this.identifier + ", " +
				"version=" + this.version +
			'}';
		}
	}
	
	//AssignedIdentifier.AssignedIdentifierBuilderImpl
	class AssignedIdentifierBuilderImpl implements AssignedIdentifier.AssignedIdentifierBuilder {
	
		protected FieldWithMetaStringBuilder identifier;
		protected Integer version;
	
		public AssignedIdentifierBuilderImpl() {
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
		public Integer getVersion() {
			return version;
		}
		
	
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder setVersion(Integer version) {
			this.version = version==null?null:version;
			return this;
		}
		
		@Override
		public AssignedIdentifier build() {
			return new AssignedIdentifier.AssignedIdentifierImpl(this);
		}
		
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssignedIdentifier.AssignedIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssignedIdentifier.AssignedIdentifierBuilder o = (AssignedIdentifier.AssignedIdentifierBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssignedIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssignedIdentifierBuilder {" +
				"identifier=" + this.identifier + ", " +
				"version=" + this.version +
			'}';
		}
	}
}
