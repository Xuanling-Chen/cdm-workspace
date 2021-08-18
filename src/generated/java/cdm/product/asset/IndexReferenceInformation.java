package cdm.product.asset;

import cdm.base.staticdata.party.LegalEntity;
import cdm.product.asset.meta.IndexReferenceInformationMeta;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum.FieldWithMetaIndexAnnexSourceEnumBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining a Credit Default Swap Index.
 * @version ${project.version}
 */
@RosettaClass

public interface IndexReferenceInformation extends RosettaModelObject, GlobalKey {
	IndexReferenceInformation build();
	IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder();
	
	/**
	 * Excluded reference entity.
	 */
	List<? extends LegalEntity> getExcludedReferenceEntity();
	/**
	 * A CDS index series annex date.
	 */
	Date getIndexAnnexDate();
	/**
	 * A CDS index series annex source.
	 */
	FieldWithMetaIndexAnnexSourceEnum getIndexAnnexSource();
	/**
	 * A CDS index series version identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexAnnexVersion();
	/**
	 * A CDS index identifier (e.g. RED pair code).
	 */
	List<? extends FieldWithMetaString> getIndexId();
	/**
	 * The name of the index expressed as a free format string with an associated scheme.
	 */
	FieldWithMetaString getIndexName();
	/**
	 * A CDS index series identifier, e.g. 1, 2, 3 etc.
	 */
	Integer getIndexSeries();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
	 */
	SettledEntityMatrix getSettledEntityMatrix();
	/**
	 * This element contains CDS tranche terms.
	 */
	Tranche getTranche();
	final static IndexReferenceInformationMeta metaData = new IndexReferenceInformationMeta();
	
	@Override
	default RosettaMetaData<? extends IndexReferenceInformation> metaData() {
		return metaData;
	} 
			
	static IndexReferenceInformation.IndexReferenceInformationBuilder builder() {
		return new IndexReferenceInformation.IndexReferenceInformationBuilderImpl();
	}
	
	default Class<? extends IndexReferenceInformation> getType() {
		return IndexReferenceInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
		processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
		processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
		
		processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.class, getExcludedReferenceEntity());
		processRosetta(path.newSubPath("indexAnnexSource"), processor, FieldWithMetaIndexAnnexSourceEnum.class, getIndexAnnexSource());
		processRosetta(path.newSubPath("indexId"), processor, FieldWithMetaString.class, getIndexId());
		processRosetta(path.newSubPath("indexName"), processor, FieldWithMetaString.class, getIndexName());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.class, getSettledEntityMatrix());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
	}
	
	
	interface IndexReferenceInformationBuilder extends IndexReferenceInformation, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int _index);
		List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity();
		FieldWithMetaIndexAnnexSourceEnumBuilder getOrCreateIndexAnnexSource();
		FieldWithMetaIndexAnnexSourceEnumBuilder getIndexAnnexSource();
		FieldWithMetaStringBuilder getOrCreateIndexId(int _index);
		List<? extends FieldWithMetaStringBuilder> getIndexId();
		FieldWithMetaStringBuilder getOrCreateIndexName();
		FieldWithMetaStringBuilder getIndexName();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix();
		SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix();
		Tranche.TrancheBuilder getOrCreateTranche();
		Tranche.TrancheBuilder getTranche();
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity, int _idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(Date indexAnnexDate);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(FieldWithMetaIndexAnnexSourceEnum indexAnnexSource);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSourceValue(IndexAnnexSourceEnum indexAnnexSource);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer indexAnnexVersion);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(FieldWithMetaString indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(FieldWithMetaString indexId, int _idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(String indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(String indexId, int _idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(List<? extends FieldWithMetaString> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexId(List<? extends FieldWithMetaString> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(List<? extends String> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexIdValue(List<? extends String> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexName(FieldWithMetaString indexName);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexNameValue(String indexName);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer indexSeries);
		IndexReferenceInformation.IndexReferenceInformationBuilder setMeta(MetaFields meta);
		IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix);
		IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche tranche);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("indexAnnexDate"), Date.class, getIndexAnnexDate(), this);
			processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
			processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
			
			processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getExcludedReferenceEntity());
			processRosetta(path.newSubPath("indexAnnexSource"), processor, FieldWithMetaIndexAnnexSourceEnumBuilder.class, getIndexAnnexSource());
			processRosetta(path.newSubPath("indexId"), processor, FieldWithMetaStringBuilder.class, getIndexId());
			processRosetta(path.newSubPath("indexName"), processor, FieldWithMetaStringBuilder.class, getIndexName());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.SettledEntityMatrixBuilder.class, getSettledEntityMatrix());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
		}
		
	}
	
	//IndexReferenceInformation.IndexReferenceInformationImpl
	class IndexReferenceInformationImpl implements IndexReferenceInformation {
		private final List<? extends LegalEntity> excludedReferenceEntity;
		private final Date indexAnnexDate;
		private final FieldWithMetaIndexAnnexSourceEnum indexAnnexSource;
		private final Integer indexAnnexVersion;
		private final List<? extends FieldWithMetaString> indexId;
		private final FieldWithMetaString indexName;
		private final Integer indexSeries;
		private final MetaFields meta;
		private final SettledEntityMatrix settledEntityMatrix;
		private final Tranche tranche;
		
		protected IndexReferenceInformationImpl(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			this.excludedReferenceEntity = ofNullable(builder.getExcludedReferenceEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.indexAnnexDate = builder.getIndexAnnexDate();
			this.indexAnnexSource = ofNullable(builder.getIndexAnnexSource()).map(f->f.build()).orElse(null);
			this.indexAnnexVersion = builder.getIndexAnnexVersion();
			this.indexId = ofNullable(builder.getIndexId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.indexName = ofNullable(builder.getIndexName()).map(f->f.build()).orElse(null);
			this.indexSeries = builder.getIndexSeries();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.settledEntityMatrix = ofNullable(builder.getSettledEntityMatrix()).map(f->f.build()).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends LegalEntity> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnum getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getIndexId() {
			return indexId;
		}
		
		@Override
		public FieldWithMetaString getIndexName() {
			return indexName;
		}
		
		@Override
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public SettledEntityMatrix getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			IndexReferenceInformation.IndexReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			ofNullable(getExcludedReferenceEntity()).ifPresent(builder::setExcludedReferenceEntity);
			ofNullable(getIndexAnnexDate()).ifPresent(builder::setIndexAnnexDate);
			ofNullable(getIndexAnnexSource()).ifPresent(builder::setIndexAnnexSource);
			ofNullable(getIndexAnnexVersion()).ifPresent(builder::setIndexAnnexVersion);
			ofNullable(getIndexId()).ifPresent(builder::setIndexId);
			ofNullable(getIndexName()).ifPresent(builder::setIndexName);
			ofNullable(getIndexSeries()).ifPresent(builder::setIndexSeries);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSettledEntityMatrix()).ifPresent(builder::setSettledEntityMatrix);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformation {" +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexId=" + this.indexId + ", " +
				"indexName=" + this.indexName + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"meta=" + this.meta + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
	
	//IndexReferenceInformation.IndexReferenceInformationBuilderImpl
	class IndexReferenceInformationBuilderImpl implements IndexReferenceInformation.IndexReferenceInformationBuilder, GlobalKeyBuilder {
	
		protected List<LegalEntity.LegalEntityBuilder> excludedReferenceEntity = new ArrayList<>();
		protected Date indexAnnexDate;
		protected FieldWithMetaIndexAnnexSourceEnumBuilder indexAnnexSource;
		protected Integer indexAnnexVersion;
		protected List<FieldWithMetaStringBuilder> indexId = new ArrayList<>();
		protected FieldWithMetaStringBuilder indexName;
		protected Integer indexSeries;
		protected MetaFields.MetaFieldsBuilder meta;
		protected SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix;
		protected Tranche.TrancheBuilder tranche;
	
		public IndexReferenceInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		public LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int _index) {
		
			if (excludedReferenceEntity==null) {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			LegalEntity.LegalEntityBuilder result;
			return getIndex(excludedReferenceEntity, _index, () -> {
						LegalEntity.LegalEntityBuilder newExcludedReferenceEntity = LegalEntity.builder();
						return newExcludedReferenceEntity;
					});
		}
		
		@Override
		public Date getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnumBuilder getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		public FieldWithMetaIndexAnnexSourceEnumBuilder getOrCreateIndexAnnexSource() {
			FieldWithMetaIndexAnnexSourceEnumBuilder result;
			if (indexAnnexSource!=null) {
				result = indexAnnexSource;
			}
			else {
				result = indexAnnexSource = FieldWithMetaIndexAnnexSourceEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getIndexId() {
			return indexId;
		}
		
		public FieldWithMetaStringBuilder getOrCreateIndexId(int _index) {
		
			if (indexId==null) {
				this.indexId = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(indexId, _index, () -> {
						FieldWithMetaStringBuilder newIndexId = FieldWithMetaString.builder();
						return newIndexId;
					});
		}
		
		@Override
		public FieldWithMetaStringBuilder getIndexName() {
			return indexName;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIndexName() {
			FieldWithMetaStringBuilder result;
			if (indexName!=null) {
				result = indexName;
			}
			else {
				result = indexName = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public Integer getIndexSeries() {
			return indexSeries;
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
		public SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix() {
			SettledEntityMatrix.SettledEntityMatrixBuilder result;
			if (settledEntityMatrix!=null) {
				result = settledEntityMatrix;
			}
			else {
				result = settledEntityMatrix = SettledEntityMatrix.builder();
			}
			
			return result;
		}
		
		@Override
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
	
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity) {
			if (excludedReferenceEntity!=null) this.excludedReferenceEntity.add(excludedReferenceEntity.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity, int _idx) {
			getIndex(this.excludedReferenceEntity, _idx, () -> excludedReferenceEntity.toBuilder());
			return this;
		}
		@Override 
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys != null) {
				for (LegalEntity toAdd : excludedReferenceEntitys) {
					this.excludedReferenceEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys == null)  {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			else {
				this.excludedReferenceEntity = excludedReferenceEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(Date indexAnnexDate) {
			this.indexAnnexDate = indexAnnexDate==null?null:indexAnnexDate;
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(FieldWithMetaIndexAnnexSourceEnum indexAnnexSource) {
			this.indexAnnexSource = indexAnnexSource==null?null:indexAnnexSource.toBuilder();
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSourceValue(IndexAnnexSourceEnum indexAnnexSource) {
			this.getOrCreateIndexAnnexSource().setValue(indexAnnexSource);
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer indexAnnexVersion) {
			this.indexAnnexVersion = indexAnnexVersion==null?null:indexAnnexVersion;
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(FieldWithMetaString indexId) {
			if (indexId!=null) this.indexId.add(indexId.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(FieldWithMetaString indexId, int _idx) {
			getIndex(this.indexId, _idx, () -> indexId.toBuilder());
			return this;
		}
		
			@Override
			public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(String indexId) {
				this.getOrCreateIndexId(-1).setValue(indexId);
				return this;
			}
			
			@Override
			public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(String indexId, int _idx) {
				this.getOrCreateIndexId(_idx).setValue(indexId);
				return this;
			}
		@Override 
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(List<? extends FieldWithMetaString> indexIds) {
			if (indexIds != null) {
				for (FieldWithMetaString toAdd : indexIds) {
					this.indexId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexId(List<? extends FieldWithMetaString> indexIds) {
			if (indexIds == null)  {
				this.indexId = new ArrayList<>();
			}
			else {
				this.indexId = indexIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexIdValue(List<? extends String> indexIds) {
			if (indexIds != null) {
				for (String toAdd : indexIds) {
					this.addIndexIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexIdValue(List<? extends String> indexIds) {
			this.indexId.clear();
			if (indexIds!=null) {
				indexIds.forEach(this::addIndexIdValue);
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexName(FieldWithMetaString indexName) {
			this.indexName = indexName==null?null:indexName.toBuilder();
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexNameValue(String indexName) {
			this.getOrCreateIndexName().setValue(indexName);
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer indexSeries) {
			this.indexSeries = indexSeries==null?null:indexSeries;
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix) {
			this.settledEntityMatrix = settledEntityMatrix==null?null:settledEntityMatrix.toBuilder();
			return this;
		}
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche tranche) {
			this.tranche = tranche==null?null:tranche.toBuilder();
			return this;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return new IndexReferenceInformation.IndexReferenceInformationImpl(this);
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder prune() {
			excludedReferenceEntity = excludedReferenceEntity.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (indexAnnexSource!=null && !indexAnnexSource.prune().hasData()) indexAnnexSource = null;
			indexId = indexId.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (indexName!=null && !indexName.prune().hasData()) indexName = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (settledEntityMatrix!=null && !settledEntityMatrix.prune().hasData()) settledEntityMatrix = null;
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExcludedReferenceEntity()!=null && getExcludedReferenceEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIndexAnnexDate()!=null) return true;
			if (getIndexAnnexSource()!=null) return true;
			if (getIndexAnnexVersion()!=null) return true;
			if (getIndexId()!=null && !getIndexId().isEmpty()) return true;
			if (getIndexName()!=null) return true;
			if (getIndexSeries()!=null) return true;
			if (getSettledEntityMatrix()!=null && getSettledEntityMatrix().hasData()) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformation.IndexReferenceInformationBuilder o = (IndexReferenceInformation.IndexReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getExcludedReferenceEntity(), o.getExcludedReferenceEntity(), this::getOrCreateExcludedReferenceEntity);
			merger.mergeRosetta(getIndexAnnexSource(), o.getIndexAnnexSource(), this::setIndexAnnexSource);
			merger.mergeRosetta(getIndexId(), o.getIndexId(), this::getOrCreateIndexId);
			merger.mergeRosetta(getIndexName(), o.getIndexName(), this::setIndexName);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getSettledEntityMatrix(), o.getSettledEntityMatrix(), this::setSettledEntityMatrix);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			
			merger.mergeBasic(getIndexAnnexDate(), o.getIndexAnnexDate(), this::setIndexAnnexDate);
			merger.mergeBasic(getIndexAnnexVersion(), o.getIndexAnnexVersion(), this::setIndexAnnexVersion);
			merger.mergeBasic(getIndexSeries(), o.getIndexSeries(), this::setIndexSeries);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationBuilder {" +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexId=" + this.indexId + ", " +
				"indexName=" + this.indexName + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"meta=" + this.meta + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"tranche=" + this.tranche +
			'}';
		}
	}
}
